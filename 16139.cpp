#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    int q, start, end;
    string str;
    char alpha;
    

    cin >> str >> q;

    auto arr = new int [str.length() + 1][26];

    for (int i = 0; i < str.length(); i++)
    {
        for (int j = 0;j<26;j++)
        {
            if (j == (int)(str[i] - 'a'))
                arr[i + 1][j] = arr[i][j] + 1;
            else
                arr[i + 1][j] = arr[i][j];
        }
    }

    while (q--)
    {
        cin >> alpha >> start >> end;
        cout << arr[end + 1][alpha - 'a'] - arr[start][alpha - 'a'] << '\n';
    }

    return 0;
}