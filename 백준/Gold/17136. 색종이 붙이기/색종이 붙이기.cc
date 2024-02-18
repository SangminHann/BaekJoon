#include <iostream>
#define MIN(x, y) ((x) < (y) ? (x) : (y))

using namespace std;

int paper[10][10], colorPaper[6], minCnt = 1e9;

int check(int y, int x, int n)
{
    int eY = y + n - 1, eX = x + n - 1;
    if (eY >= 10 || eX >= 10)
        return 0;
    
    for (int i = y; i <= eY; i++)
        for (int j = x; j <= eX; j++)
            if (!paper[i][j])
                return 0;

    return 1;
}

void coverPaper(int y, int x, int n)
{
    int eY = y + n - 1, eX = x + n - 1;
    
    for (int i = y; i <= eY; i++)
        for (int j = x; j <= eX; j++)
            paper[i][j] = 0;
}

void uncoverPaper(int y, int x, int n)
{
    int eY = y + n - 1, eX = x + n - 1;
    
    for (int i = y; i <= eY; i++)
        for (int j = x; j <= eX; j++)
            paper[i][j] = 1;
}

void backTracking(int y, int x, int cnt)
{
    if (minCnt < cnt)
        return;

    while (!paper[y][x])
    {
        if (++x > 9)
        {
            if (++y > 9)
            {
                minCnt = MIN(minCnt, cnt);
                return ;
            }

            x = 0;
        }
    }

    for (int k = 5; k > 0; k--)
    {
        if (!colorPaper[k] || !check(y, x, k))
            continue;
        
        --colorPaper[k];
        coverPaper(y, x, k);
        backTracking(y, x, cnt + 1);
        ++colorPaper[k];
        uncoverPaper(y, x, k);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    for (int i = 0; i < 6; i++)
        colorPaper[i] = 5;

    for (int i = 0; i < 10; i++)
        for (int j = 0; j < 10; j++)
            cin >> paper[i][j];

    backTracking(0, 0, 0);
    (minCnt != 1e9) ? (cout << minCnt) : (cout << -1);
    
    return 0;
}