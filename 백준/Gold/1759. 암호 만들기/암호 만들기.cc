#include <iostream>

using namespace std;

char rst[17] = {0}, alpha[26] = {0};
int l, c;

int isMo(char a)
{
    if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
        return 1;
    return 0;
}

void backTracking(int s, int idx, int za, int mo)
{
    if (idx == l)
    {
        if (za >= 2 && mo >= 1)
            cout << rst;
        return ;
    }

    for (int i = s; i < 26; i++)
    {
        if (!alpha[i])
            continue;

        rst[idx] = i + 'a';
        if (isMo(i + 'a'))
            backTracking(i + 1, idx + 1, za, mo + 1);
        else
            backTracking(i + 1, idx + 1, za + 1, mo);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    char tmp;
    cin >> l >> c;

    for (int i = 0; i < c; i++)
    {
        cin >> tmp;
        alpha[tmp - 'a'] = 1;
    }
    rst[l] = '\n';
    backTracking(0, 0, 0, 0);

    return 0;
}