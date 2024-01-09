#include <iostream>
#include <climits>
#define MIN(x, y) ((x) < (y) ? x : y)

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int T, minNum, rst, tmp;

    cin >> T;
    while (T--)
    {
        rst = 0;
        minNum = INT_MAX;
        for (int i = 0; i < 7; i++)
        {
            cin >> tmp;
        
            if (tmp % 2 == 0)
            {
                rst += tmp;
                minNum = MIN(minNum, tmp);
            }
        }

        cout << rst << " " << minNum << "\n";
    }

    return 0;
}