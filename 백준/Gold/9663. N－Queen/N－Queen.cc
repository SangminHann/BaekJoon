#include <iostream>
#define ABS(x) ((x) > 0 ? (x) : -(x))

using namespace std;

int n, cnt = 0, board[16], visited[16] = {0,};

int isAttack(int y)
{
    for (int i = 1; i < y; i++)
    {
        if (ABS(y - i) == ABS(board[y] - board[i]))
            return 1;
    }

    return 0;
}

void nQueen(int y)
{
    if (y > n)
    {
        ++cnt;
        return ;
    }

    for (int i = 1; i <= n; i++)
    {
        if (!visited[i])
        {
            board[y] = i;
            if (!isAttack(y))
            {
                visited[i] = 1;
                nQueen(y + 1);
                visited[i] = 0;
            }
        }      
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    nQueen(1);
    cout << cnt;

    return 0;
}