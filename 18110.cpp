#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    double rst = 0;
    int n, start, end;
    cin >> n;

    if (!n)
    {
        cout << 0;
        return 0;
    }
    
    vector<double> arr(n);

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    sort(arr.begin(), arr.end());

    start = (int)round((double)n * 0.15);
    end = n - start;

    for (int i = start; i < end; i++)
        rst += arr[i];

    cout << (int)round(rst / (double)(end - start));

    return 0;
}