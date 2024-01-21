#include <iostream>
#include <vector>
#define MAX(x, y) ((x) < (y) ? (y) : (x))

using namespace std;

int dx[] = {0, 0, -1, 1}, dy[] = {1, -1, 0, 0};
int x, y, cnt;

void dfs(vector<vector<int>> &waste, int _x, int _y)
{
    if (_x > x || _y > y || _x < 0 || _y < 0)
        return;
    if (!waste[_y][_x])
        return;
    waste[_y][_x] = 0;
    ++cnt;

    for (int i = 0; i < 4; i++)
        dfs(waste, _x + dx[i], _y + dy[i]);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int wasteNum, tmpX, tmpY, rst;

    cin >> y >> x >> wasteNum;
    vector<vector<int>> waste(y + 1, vector<int>(x + 1, 0));
    rst = 0;

    while (wasteNum--)
    {
        cin >> tmpY >> tmpX;
        waste[tmpY][tmpX] = 1;
    }

    for (int i = 1; i <= y; i++)
    {
        for (int j = 1; j <= x; j++)
        {
            if (waste[i][j])
            {
                cnt = 0;
                dfs(waste, j, i);
                rst = MAX(rst, cnt);
            }
        }
    }
    cout << rst << "\n";

    return 0;
}