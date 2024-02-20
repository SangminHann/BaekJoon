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
            if (answer.find(word[i]) != string::npos)
            {
                cout << answer;
                return 0;
            }
        }

        for (int i = 0; i < (int)answer.length(); i++)
            answer[i] = (answer[i] - 96) % 26 + 'a';
    }

    return 0;
}