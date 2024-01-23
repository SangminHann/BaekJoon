#include <iostream>
#include <queue>
#include <vector>
#include <tuple>
#define MAX(x, y) ((x) > (y) ? (x) : (y))

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int y, x, dy[4] = {0, 0, -1, 1}, dx[4] = {1, -1, 0 ,0}, rst = -1;
    cin >> x >> y;

    vector<vector<int>> tomato(y, vector<int>(x));
    queue<tuple<int, int, int>> q;
    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            cin >> tomato[i][j];
            if (tomato[i][j] == 1)
                q.emplace(i, j, 0);
        }
    }

    int nextX, nextY;
    while (!q.empty())
    {
        auto [curY, curX, day] = q.front();
        q.pop();
        rst = MAX(rst, day);

        for (int i = 0; i < 4; i++)
        {
            nextY = curY + dy[i];
            if (nextY < 0 || nextY == y)
                continue;

            nextX = curX + dx[i];
            if (nextX < 0 || nextX == x || tomato[nextY][nextX] == 1 || tomato[nextY][nextX] == -1)
            continue;

            q.emplace(nextY, nextX, day + 1);
            tomato[nextY][nextX] = 1;
        }
    }
    
    for (auto &a : tomato)
    {
        for (auto &b : a)
        {
            if (!b)
            {
                cout << -1;
                return 0;
            }
        }
    }

    cout << rst;

    return 0;
}