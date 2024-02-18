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

int isAllCovered()
{
    for (int i = 0; i < 10; i++)
        for (int j = 0; j < 10; j++)
            if (paper[i][j])
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

    if (isAllCovered())
    {
        minCnt = MIN(minCnt, cnt);
        return ;
    }

    int i = y, j = x;

    for (; i < 10; i++)
    {
        for (; j < 10; j++)
        {
            if (!paper[i][j])
                continue;
            for (int k = 5; k > 0; k--)
            {
                if (!colorPaper[k] || !check(i, j, k))
                    continue;
                
                --colorPaper[k];
                coverPaper(i, j, k);
                backTracking(i, j + k, cnt + 1);
                ++colorPaper[k];
                uncoverPaper(i, j, k);
            }

            return ;
        }
        j = 0;
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