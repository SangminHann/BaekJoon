#include <iostream>

using namespace std;

int rst[8], n, maxIdx;

void backTracking(int s, int idx)
{
    if (idx == maxIdx)
    {
        for (int i = 0; i < maxIdx; i++)
            cout << rst[i] << ' ';
        cout << '\n';

        return ;
    }

    for (int i = s; i <= n; i++)
    {
        rst[idx] = i;
        backTracking(i + 1 ,idx + 1);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> maxIdx;
    backTracking(1, 0);

    return 0;
}