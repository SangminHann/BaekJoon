#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int num[1000], n, rst = 0;
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> num[i];
    sort(num, num + n);

    vector<int> sum;
    sum.reserve((n * (n - 1)));
    for (int i = 0; i < n; i++)
        for (int j = i; j < n; j++)
            sum.emplace_back(num[i] + num[j]);

    sort(sum.begin(), sum.end());
    for (int i = n - 1; i >= 0; i--)
    {
        for (int j = 0; j < i; j++)
        {
            if (binary_search(sum.begin(), sum.end(), num[i] - num[j]))
            {
                cout << num[i];
                return 0;
            }
        }
    }

    return 0;
}