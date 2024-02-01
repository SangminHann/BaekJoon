#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int y, x, dx[4] = {0, 0, -1, 1}, dy[4] = {1, -1, 0, 0}, minDist = -1;

    cin >> y >> x;

    vector<string> maze(y);
    for (auto &a : maze)
        cin >> a;
    queue<tuple<int, int, int, int>> q;

    q.emplace(0, 0, 0, 1);
    maze[0][0] = '2';

    int nextX, nextY;
    while (!q.empty())
    {
        auto [isWallBreak, curY, curX, dist] = q.front();
        if (curY == y - 1 && curX == x - 1)
        {
            minDist = dist;
            break;
        }
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            nextX = curX + dx[i];
            if (nextX == x || nextX < 0)
                continue;

            nextY = curY + dy[i];
            if (nextY == y || nextY < 0 || maze[nextY][nextX] == '2')
                continue;
            
            if (isWallBreak == 0)
            {
                if (maze[nextY][nextX] == '1')
                {
                    maze[nextY][nextX] = '3';
                    q.emplace(1, nextY, nextX, dist + 1);
                }
                else if (maze[nextY][nextX] != '3')
                {
                    maze[nextY][nextX] = '2';
                    q.emplace(0, nextY, nextX, dist + 1);
                }
            }

            else if (maze[nextY][nextX] == '0')
            {
                q.emplace(1, nextY, nextX, dist + 1);
                maze[nextY][nextX] = '4';
            }
        }
    }
    cout << minDist;

    return 0;
}