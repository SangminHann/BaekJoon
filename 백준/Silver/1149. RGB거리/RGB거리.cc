#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int house[1000][3], dp[1001][3] = {0,}, n, minCost;

    cin >> n;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < 3; j++)
            cin >> house[i][j];

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            minCost = 1e9;
            for (int k = 0; k < 3; k++)
            {
                if (j == k)
                    continue;
                minCost = min(dp[i][k], minCost);
            }
            dp[i + 1][j] = house[i][j] + minCost;
        }
    }

    cout << (min({dp[n][0], dp[n][1], dp[n][2]}));

    return 0;
}