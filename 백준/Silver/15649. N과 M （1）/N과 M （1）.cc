#include <iostream>

using namespace std;
int* visit, * arr, maxN, num;
void recursive(int n);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> maxN >> num;
    
    visit = new int[maxN + 1]{ 0 };
    arr = new int[maxN + 1]{ 0 };
    recursive(0);
}

void recursive(int n)
{
    if (n == num)
    {
        for (int i = 0; i < num; i++)
            cout << arr[i] << " ";
        cout << '\n';
        return;
    }
    for (int i = 1; i <= maxN; i++)
    {
        if (!visit[i])
        {
            visit[i] = 1;
            arr[n] = i;
            recursive(n + 1);
            visit[i] = false;
        }
    }
}