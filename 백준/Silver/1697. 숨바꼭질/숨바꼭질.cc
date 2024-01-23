#include <iostream>
#include <queue>

using namespace std;

int timeUsed[100001] = {0};
queue<int> coordinate;

int isValid(int n)
{
    if ((0 <= n && n <= 100000) && !timeUsed[n])
        return 1;
        
    return 0;
}

void push(int cur, int next)
{
    timeUsed[next] = timeUsed[cur] + 1;
    coordinate.push(next);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);


    int n, k;
    cin >> n >> k;

    coordinate.push(n);

    while(1)
    {
        int cur = coordinate.front();
        coordinate.pop();

        if (cur == k)
        {
            cout << timeUsed[cur];
            break;
        }

        if (isValid(cur + 1))
            push(cur, cur + 1);
        if (isValid(cur - 1))
            push(cur, cur - 1);
        if (isValid(cur * 2))
            push(cur, cur * 2);
    }

    return 0;
}