#include <iostream>
#define SIZE 246913

using namespace std;

int main(void)
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n, cnt, arr[SIZE] = { 0 }, input;

    arr[0] = arr[1] = 1;
    for (int i = 2; i < SIZE / i; i++)
        if (arr[i] != 1)
            for (n = i * i; n < SIZE; n += i) 
                if (n % i == 0)
                    arr[n] = 1;
    cin >> input;
    while (input != 0)
    {
        cnt = 0;
        for (int i = input + 1; i <= input * 2; i++)
            if (arr[i] == 0)
                cnt++;
        cout << cnt << '\n';
        cin >> input;
    }

    return 0;
}
