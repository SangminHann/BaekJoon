#include <iostream>
#include <vector>
#define MIN(x, y) ((x) < (y) ? (x) : (y))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, s, e, cnt = 1, target, sum, rst = 1e9;
    cin >> n >> target;

    vector<int> num(n);
    for (auto &a : num)
        cin >> a;
    
    sum = num[0];
    s = e = 0;

    while (e != n)
    {
        if (s > e && e < n - 1)
        {
            sum += num[++e];
            ++cnt;
        }
        
        else if (sum < target)
        {
            if (++e < n)
            {
                sum += num[e];
                ++cnt;
            }
        }

        else if (sum >= target)
        {
            rst = MIN(rst, cnt);
            sum -= num[s++];
            --cnt;
        }
    }

    (rst == 1e9) ? (cout << 0) : (cout << rst);

    return 0;
}
