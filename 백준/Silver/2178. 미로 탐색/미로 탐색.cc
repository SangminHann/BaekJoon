#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int x, y;
    int dx[4] = {0, 0, 1, -1}, dy[4] = {1, -1, 0, 0}; 
    
    cin >> y >> x;
    string maze[y];

    for (auto &a : maze)
        cin >> a;
    
    queue<tuple<int, int, int>> q;
    q.emplace(0, 0, 1);
    maze[0][0] = '0';

    while (!q.empty())
    {
        auto [curY, curX, dist] = q.front();
        q.pop();

        if (curY == y - 1 && curX == x - 1)
        {
            cout << dist;
            break;
        }

        for (int i = 0; i < 4; i++)
        {
            int nextY, nextX;

            nextY = curY + dy[i];
            if (nextY < 0 || nextY == y)
                continue;
            
            nextX = curX + dx[i];
            if (nextX < 0 || nextX == x || maze[nextY][nextX] == '0')
                continue;

            q.emplace(nextY, nextX, dist + 1);
            maze[nextY][nextX] = '0';
        }
    }

    return 0;
}