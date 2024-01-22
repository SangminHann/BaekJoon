#include <iostream>
#include <vector>
#define MIN(x, y) ((x) < (y) ? (x) : (y))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, k;

    cin >> n >> k;
    vector<int> dp(k + 1, k + 2), coin(n);

    for (auto &a : coin)
    {
        cin >> a;
        if (a <= k)
            dp[a] = 1;
    }

    for (int i = 1; i <= k; i++)
    {
        if (!dp[i])
            continue;
        
        for (auto &a : coin)
        {
            if (i + a > k)
                continue;
            
            dp[i + a] = MIN(dp[i + a], dp[i] + 1);
        }
    }

    (dp[k] != k + 2) ? (cout << dp[k]) : (cout << -1);

    return 0;
}