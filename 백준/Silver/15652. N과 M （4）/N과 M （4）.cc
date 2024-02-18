#include <iostream>

using namespace std;
int* arr, maxN, num;
void recursive(int n, int cnt);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> maxN >> num;

    arr = new int[num + 1];
    recursive(1, 1);
}

void recursive(int n, int cnt)
{
    if (cnt <= num && maxN < n)
        return;
    if (cnt > num)
    {
        for (int i = 1; i <= num; i++)
            cout << arr[i] << " ";
        cout << '\n';
        return;

    }
    for (int i = n; i <= maxN; i++)
    {
        arr[cnt] = i;
        recursive(i, cnt + 1);
    }
}
