#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int L, P, N, i;

    i = 0;
    while (++i)
    {
        cin >> L >> P >> N;
        if (!L && !P && !N)
            return 0;

        cout << "Case " << i << ": " << ((N / P) * L) + (((N % P) < L) ? (N % P) : L ) << "\n";
    }

    return 0;
}