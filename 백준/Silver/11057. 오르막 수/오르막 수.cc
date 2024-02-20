#include <iostream>
#define MIN(x, y) ((x) < (y) ? (x) : (y))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, r, **comb, maxR;
    cin >> r;

    n = 10 + r - 1;
    r = MIN(r, n - r);

    comb = new int*[n + 1];
    for (int i = 0; i <= n; i++)
        comb[i] = new int[n + 1] {0};

    for (int i = 0; i <= n; i++)
        comb[i][0] = 1;

    for (int i = 1; i <= n; i++)
    {
        maxR = MIN(i, r);
        for (int j = 1; j <= maxR; j++)
        {
            if (j == i)
                comb[i][j] = 1;
            else
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % 10007;
        }
    }

    cout << comb[n][r];

    return 0;
}