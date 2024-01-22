#include <iostream>
#define MAX(x, y) ((x) > (y) ? (x) : (y))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int dp[2][100001] = {0,}, sticker[2][100001] = {0,};
    int n, t;

    cin >> t;
    while (t--)
    {
        cin >> n;
        for (int i = 1; i <= n; i++)
            cin >> sticker[0][i];
        for (int i = 1; i <= n; i++)
            cin >> sticker[1][i];
        
        dp[0][1] = sticker[0][1];
        dp[1][1] = sticker[1][1];

        for (int i = 2; i <= n; i++)
        {
            dp[0][i] = MAX(dp[1][i - 2], dp[1][i - 1]) + sticker[0][i];
            dp[1][i] = MAX(dp[0][i - 2], dp[0][i - 1]) + sticker[1][i];
        }
        cout << MAX(dp[0][n], dp[1][n]) << '\n';
    }

    return 0;
}