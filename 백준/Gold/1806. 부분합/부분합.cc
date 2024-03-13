#include <iostream>
#include <vector>
#define MIN(x, y) ((x) < (y) ? (x) : (y))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, s = 0, e = 0, cnt = 0, target, sum = 0, rst = 1e9;
    cin >> n >> target;

    vector<int> num(n);
    for (auto &a : num)
        cin >> a;

    while (e <= n && s <= n)
    {    
        if (sum < target)
        {
            sum += num[e++];
            ++cnt;
        }

        else
        {
            rst = MIN(rst, cnt);
            sum -= num[s++];
            --cnt;
        }
    }

    (rst == 1e9) ? (cout << 0) : (cout << rst);

    return 0;
}
