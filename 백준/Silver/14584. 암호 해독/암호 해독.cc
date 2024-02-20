#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    string answer, word[20];
    cin >> answer;
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> word[i];

    while (1)
    {
        for (int i = 0; i < n; i++)
        {
            int maxLength = (int)answer.length() - (int)word[i].length();

            for (int j = 0; j <= maxLength; j++)
            {
                if (answer[j] == word[i][0])
                {
                    int k = 1;
                    while (k < (int)word[i].length() && word[i][k] == answer[j + k])
                        ++k;

                    if (k == (int)word[i].length())
                    {
                        cout << answer;
                        return 0;
                    }
                }
            }
        }

        for (int i = 0; i < (int)answer.length(); i++)
            answer[i] = (answer[i] - 96) % 26 + 'a';
    }

    return 0;
}