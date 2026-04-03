#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int a1, a0, c, n0;

    cin >> a1 >> a0 >> c >> n0;
    if (a1 * n0 + a0 > n0 * c)
        cout << "0";
    else if (a1 * 100 + a0 > 100 * c)
        cout << "0";
    else
        cout << "1";

    return 0;
}