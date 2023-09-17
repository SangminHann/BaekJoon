#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string str, bomb, tmp;
    cin >> str >> bomb;

    const int STRLEN = str.length(),  BOMBLEN = bomb.length();
    tmp.clear();

    for (int i = 0; i < STRLEN; i++)
    {
        tmp += str[i];

        if(tmp.length() >= BOMBLEN)
        {
            bool flag = true;

            for (int j = 0; j < BOMBLEN; j++)
            { 
                if(tmp[tmp.length() - BOMBLEN + j] != bomb[j])
                {
                    flag = false;
                    break;
                }
            }
 
            if(flag)
                tmp.erase(tmp.end() - BOMBLEN, tmp.end());
        }
    }

        if (tmp.empty())
            cout << "FRULA" << '\n';

        else
            cout << tmp << '\n';

    return 0;
}