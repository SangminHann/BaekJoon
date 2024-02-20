#include <iostream>
#define MAX(x, y) ((x) > (y) ? (x) : (y))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int card[10001], dp[1001] = {0, }, n;
    cin >> n;

    for (int i = 1; i <= n; i++)
        cin >> card[i];
    
    dp[1] = card[1];
    for (int i = 1; i <= n; i++)
    {
        for (int j = i; j <= n; j++)
        {
            if (!dp[j])
                dp[j] = dp[j - i] + card[i];
            else
                dp[j] = max(dp[j], dp[j - i] + card[i]);
        }
    }

    cout << dp[n];

    return 0;
}