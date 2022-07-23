#include <iostream>
#define SIZE 10001

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n, arr[SIZE] = { 0 }, input, num, prime;

    arr[0] = 1;
    arr[1] = 1;

    for (int i = 2; i < SIZE / i; i++)
        if (arr[i] != 1)
            for (n = i * i; n < SIZE; n += i) 
                if (n % i == 0)
                    arr[n] = 1;
    cin >> input;
    while (input--)
    {
        cin >> num;
        prime = num / 2;
        while (arr[prime] || arr[num - prime])
            prime -= 1;
        cout << prime << ' ' << num - prime << '\n';
    }

    return 0;
}
