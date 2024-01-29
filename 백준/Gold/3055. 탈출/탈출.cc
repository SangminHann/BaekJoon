#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int y, x, endY, endX, dx[4] = {0, 0, -1, 1}, dy[4] = {1, -1, 0, 0};
    cin >> y >> x;

    vector<string> land(y);
    for (auto &a : land)
        cin >> a;
    
    queue<tuple<int, int, int>> water, hedgehog;
    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            if (land[i][j] == '*')
                water.emplace(i, j, 0);
            else if (land[i][j] == 'S')
                hedgehog.emplace(i, j, 0);
            else if (land[i][j] == 'D')
                endY = i, endX = j;
        }
    }

    while (!hedgehog.empty())
    {
        int tmpSize = water.size(), nextY, nextX;
        while (tmpSize--)
        {
            auto [curY, curX, dist] = water.front();
            water.pop();

            for (int i = 0; i < 4; i++)
            {
                nextY = curY + dy[i];
                if (nextY == y || nextY < 0)
                    continue;
                
                nextX = curX + dx[i];
                if (nextX == x || nextX < 0 || land[nextY][nextX] == 'X' || land[nextY][nextX] == '*' || land[nextY][nextX] == 'D')
                    continue;
                
                water.emplace(nextY, nextX, dist + 1);
                land[nextY][nextX] = '*';
            }
        }

        tmpSize = hedgehog.size();
        while (tmpSize--)
        {
            auto [curY, curX, dist] = hedgehog.front();
            hedgehog.pop();

            for (int i = 0; i < 4; i++)
            {
                nextY = curY + dy[i];
                if (nextY == y || nextY < 0)
                    continue;
                
                nextX = curX + dx[i];
                if (nextX == x || nextX < 0 || land[nextY][nextX] == 'X' || land[nextY][nextX] == '*' || land[nextY][nextX] == 'S')
                    continue;
                
                hedgehog.emplace(nextY, nextX, dist + 1);
                land[nextY][nextX] = 'S';
            }

            if (land[endY][endX] == 'S')
            {
                cout << dist + 1;
                return 0;
            }
        }
    }
    cout << "KAKTUS";

    return 0;
}