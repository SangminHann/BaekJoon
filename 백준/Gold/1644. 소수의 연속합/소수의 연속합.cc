#include <iostream>
#include <vector>

using namespace std;

vector<int> prime;
int n;

void eratosthenes()
{
    vector<int> isPrime(n + 1, true);
    long long tmp = (long long)n;
    isPrime[0] = isPrime[1] = false;

    for (long long p = 2; p * p <= tmp; p++)
    {
        if (isPrime[p])
        {
            for (long long i = p * p; i <= tmp; i += p)
                isPrime[i] = false;
        }
    }

    for (int i = 2; i <= n; i++)
        if (isPrime[i])
            prime.push_back(i);
    prime.push_back(0);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    size_t s = 0, e = 0, maxIdx;
    int sum = 0, cnt = 0;
    prime.reserve(283146);
    cin >> n;

    eratosthenes();
    maxIdx = prime.size() - 1;

    while (s <= maxIdx && e <= maxIdx)
    {
        if (sum < n)
            sum += prime[e++];
        
        else if (sum == n)
        {
            ++cnt;
            sum -= prime[s++];
        }

        else
            sum -= prime[s++];
    }

    cout << cnt;

    return 0;
}