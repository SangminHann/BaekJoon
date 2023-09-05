#include <iostream>
#define ABS(x) ((x) > 0 ? (x) : -(x))

using namespace std;

int board[16];
int n, cnt;

int isAttack(int y)
{
    for (int i = 1; i < y; i++)
    {
        if (board[i] == board[y])
            return 0;
        if (y - i == ABS(board[y] - board[i]))
            return 0;
    }
    return 1;
}

void nQueen(int y)
{
    if (y > n)
        cnt++;

    else
    {
        for (int i = 1; i <= n; i++)
        {
            board[y] = i;
            if (isAttack(y))
                nQueen(y + 1);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);

    cnt = 0;
    cin >> n;

    nQueen(1);
    cout << cnt;
}