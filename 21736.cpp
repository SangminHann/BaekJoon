#include <iostream>
#include <vector>

using namespace std;


vector<vector<char>> campus;
vector<vector<char>> visited;
int n, m, cnt = 0;

int isValid(int x, int y)
{
    if (y < 0 || x < 0 || x == m || y == n)
        return 0;
    if (campus[y][x] == 'X' || visited[y][x])
        return 0;
    return 1;
}

void dfs(int x, int y)
{
    if (!isValid(x, y))
        return ;

    visited[y][x] = 1;
    if (campus[y][x] == 'P')
        ++cnt;

    dfs(x + 1, y);
    dfs(x - 1, y);
    dfs(x, y + 1);
    dfs(x, y - 1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int coorX, coorY;
    cin >> n >> m;

    campus.assign(n,vector<char>(m, 0));
    visited = campus;
    
    for (int y = 0; y < n; y++)
    {
        for (int x = 0; x < m; x++)
        {
            cin >> campus[y][x];
            if (campus[y][x] == 'I')
            {
                coorX = x;
                coorY = y;
            }
        }
    }

    dfs(coorX, coorY);

    if (cnt)
        cout << cnt;
    else
        cout << "TT";

    return 0;
}