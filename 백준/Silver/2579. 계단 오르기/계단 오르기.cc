#include <iostream>
#define MAX(x, y) ((x) > (y) ? (x) : (y))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int stair[300]{0}, dp[300], n;

    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> stair[i];

    dp[0] = stair[0];
    dp[1] = stair[0] + stair[1];
    dp[2] = MAX(dp[0] + stair[2], stair[1] + stair[2]);

    for (int i = 3; i < n; i++)
        dp[i] = MAX(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);

    cout << dp[n - 1];

    return 0;
}