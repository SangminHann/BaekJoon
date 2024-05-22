#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string str;
    int l, n, cnt = 0;

    cin >> l >> n >> str;
    for (int i = 0; i < l; i++)
    {
        if (str[i] == 'w')
            ++cnt;
        else if (str[i] == 'h')
        {
            cnt = (cnt < n) ? cnt : n;
            str[i] = 'w';
            str[i - cnt] = 'h';
        }
        else
            cnt = 0;
    }

    cout << str;

    return 0;
}