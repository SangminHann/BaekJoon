#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int wall[4] = {1, 2, 4, 8};
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, -1, 0, 1};

int MAX(int x, int y)
{
    if (x > y)  return x;
    return y;
}

int roomSize(vector<vector<int>> &room, vector<vector<char>> &visited, int y, int x)
{
    int cnt = 1;
    queue<pair<int, int>> q;

    q.emplace(y, x);
    visited[y][x] = 1;

    int nextY, nextX;
    while(!q.empty())
    {
        auto [curY, curX] = q.front();
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            if (!(room[curY][curX] & wall[i]))
            {
                nextX = curX + dx[i];
                nextY = curY + dy[i];
                
                if (nextX < 0 || nextY < 0 || nextX == (int)room[0].size() || nextY == (int)room.size())
                    continue;
                if (!visited[nextY][nextX])
                {
                    visited[nextY][nextX] = 1;
                    ++cnt;
                    q.emplace(nextY, nextX);
                }
            }
        }
    }

    return cnt;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int x, y, maxRoomSize = 0, roomCnt= 0;
    cin >> x >> y;
    
    vector<vector<char>> visited(y, vector<char>(x, 0));
    vector<vector<int>> room(y, vector<int>(x));
    for (int i = 0; i < y; i++)
        for (int j = 0; j < x; j++)
            cin >> room[i][j];

    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            if (!visited[i][j])
            {
                ++roomCnt;
                maxRoomSize = MAX(maxRoomSize, roomSize(room, visited, i, j));
            }
        }
    }

    cout << roomCnt << "\n" << maxRoomSize << "\n";
    maxRoomSize = 0;

    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            for (int k = 0; k < 4; k++)
            {
                if (room[i][j] & wall[k])
                {
                    room[i][j] -= wall[k];
                    visited = vector<vector<char>>(y, vector<char>(x, 0));
                    maxRoomSize = MAX(maxRoomSize, roomSize(room, visited, i, j));
                    room[i][j] += wall[k];
                }
            }
        }
    }

    cout << maxRoomSize;

    return 0;
}