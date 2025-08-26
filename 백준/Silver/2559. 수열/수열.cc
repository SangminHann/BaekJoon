#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, k;

    cin >> n >> k;
    vector<int> arr(n), sum(n + 1, 0), rst(n - k + 1, 0);

    for (int i = 0; i < n; i++)
        cin >> arr[i];
    
    for (int i = 0; i < n; i++)
        sum[i + 1] = sum[i] + arr[i];

    for (int i = 0; i < n - k + 1; i++)
        rst[i] = sum[i + k] - sum[i];

    sort(rst.begin(), rst.end());

    cout << rst.back();

    return 0;
}