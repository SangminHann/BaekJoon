#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int maxDist = 0, y, x;
int dy[] = {0, 0, -1, 1}, dx[] = {1, -1, 0, 0};
vector<string> island;

void bfs(int startY, int startX)
{
    vector<vector<int>> visited(y, vector<int>(x, 0));
    visited[startY][startX] = 1;
    queue<tuple<int, int, int>> q;

    q.emplace(startY, startX, 0);
    while (!q.empty())
    {
        auto [curY, curX, dist] = q.front();
        q.pop();
        maxDist = maxDist < dist ? dist : maxDist;

        int nextY, nextX;
        for (int i = 0; i < 4; i++)
        {
            nextY = curY + dy[i];
            if (nextY < 0 || nextY == y)
                continue;

            nextX = curX + dx[i];
            if (nextX < 0 || nextX == x || visited[nextY][nextX] || island[nextY][nextX] == 'W')
                continue;

            visited[nextY][nextX] = 1;
            q.emplace(nextY, nextX, dist + 1);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> y >> x;
    vector<string> tmp(y);
    for (auto &a : tmp)
        cin >> a;
    island = tmp;

    for (int i = 0; i < y; i++)
        for (int j = 0; j < x; j++)
            if (island[i][j] == 'L')
                bfs(i, j);

    cout << maxDist;

    return 0;
}