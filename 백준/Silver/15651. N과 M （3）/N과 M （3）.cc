#include <iostream>

using namespace std;
int* arr, maxN, num;
void recursive(int cnt);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> maxN >> num;

    arr = new int[num + 1];
    recursive(1);
}

void recursive(int cnt)
{
    if (cnt > num)
    {
        for (int i = 1; i <= num; i++)
            cout << arr[i] << " ";
        cout << '\n';
        return;
    }

    for (int i = 1; i <= maxN; i++)
    {
        arr[cnt] = i;
        recursive(cnt + 1);
    }
}