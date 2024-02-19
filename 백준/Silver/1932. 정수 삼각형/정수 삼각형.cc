#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, triangle[500][500], dp[500][500], rst = 0;
    cin >> n;

    for (int i = 0; i < n; i++)
        for (int j = 0; j <= i; j++)
            cin >> triangle[i][j];

    dp[0][0] = triangle[0][0];
    for (int i = 1; i < n; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            if (j == 0)
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
            else if (j == i)
                dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
            else
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
        }
    }

    --n;
    for (int i = 0; i <= n; i++)
        rst = max(rst, dp[n][i]);
    cout << rst;

    return 0;
}