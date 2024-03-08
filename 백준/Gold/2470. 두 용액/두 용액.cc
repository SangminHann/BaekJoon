#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#define ABS(x) ((x) > 0 ? (x) : -(x))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, s, e, tmp, minRst = INT_MAX, a, b;
    cin >> n;

    vector<int> num(n);
    for (auto &a : num)
        cin >> a;
    
    sort(num.begin(), num.end());
    s = 0;
    e = n - 1;

    while (s < e)
    {
        tmp = num[s] + num[e];

        if (minRst > ABS(tmp))
        {
            minRst = ABS(tmp);
            a = num[s];
            b = num[e];

            if (!tmp)
                break;
        }

        if (tmp > 0)
            --e;

        else
            ++s;
    }

    cout << a << ' ' << b;

    return 0;
}
