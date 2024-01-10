#include <iostream>
#define MAX(x, y) ((x) > (y) ? (x) : (y))

using namespace std;
string board[51];
int maxCandy = 0, n;

void cntColumn()
{
    int cnt;
    char cur;

    for (int i = 0; i < n; i++)
    {
        cnt = 0;
        cur = board[i][0];
        for (int j = 0; j < n; j++)
        {
            if (cur == board[i][j])
                ++cnt;
            else
            {
                cur = board[i][j];
                maxCandy = MAX(maxCandy, cnt);
                cnt = 1;
            }
        }

        maxCandy = MAX(maxCandy, cnt);
    }
}

void cntRow()
{
    int cnt;
    char cur;

    for (int i = 0; i < n; i++)
    {
        cnt = 0;
        cur = board[0][i];
        for (int j = 0; j < n; j++)
        {
            if (cur == board[j][i])
                ++cnt;
            else
            {
                cur = board[j][i];
                maxCandy = MAX(maxCandy, cnt);
                cnt = 1;
            }
        }
        
        maxCandy = MAX(maxCandy, cnt);
    }
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    char tmp;
    cin >> n;

    for (int i = 0; i < n; i++)
            cin >> board[i];

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (j + 1 < n)
            {
                tmp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = tmp;

                cntRow();
                cntColumn();

                tmp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = tmp;
            }

            if (i + 1 < n)
            {
                tmp = board[i][j];
                board[i][j] = board[i + 1][j];
                board[i + 1][j] = tmp;

                cntRow();
                cntColumn();

                tmp = board[i][j];
                board[i][j] = board[i + 1][j];
                board[i + 1][j] = tmp;
            }
        }
    }

    cout << maxCandy;

    return 0;
}