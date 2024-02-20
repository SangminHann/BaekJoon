#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string s, t;
    int rst;

    while (cin >> s >> t)
    {
        rst = 0;
        for (auto &a : t)
            if (a == s[rst])
                if (++rst == (int)s.length())
                    break;

        (rst == (int)s.length()) ? (cout << "Yes\n") : (cout << "No\n");
    }

    return 0;
}