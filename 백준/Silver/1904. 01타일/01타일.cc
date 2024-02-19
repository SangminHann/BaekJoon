#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    long long *a;

    cin >> n;
    a = new long long [n + 1];

    a[0] = 1;
    a[1] = 1;

    for (int i = 2; i <= n; i++)
        a[i] = (a[i - 1] + a [i - 2]) % 15746;

    cout << a[n];

    return 0;
}