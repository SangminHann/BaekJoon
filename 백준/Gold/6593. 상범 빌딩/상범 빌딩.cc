#include <iostream>
#include <vector>
#include <tuple>
#include <queue>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int floor, y, x, startF, startY, startX, endF, endY, endX, flag;
    int dx[6] = {0, 0, 0, 0, -1, 1}, dy[6] = {0, 0, -1, 1, 0, 0}, df[6] = {-1, 1, 0, 0, 0, 0};
    
    cin >> floor >> y >> x;

    while (floor && y && x)
    {
        vector<vector<string>> building(floor, vector<string>(y));
        for (auto &a : building)
            for (auto &b : a)
                cin >> b;

        for (int i = 0; i < floor; i++)
        {
            for (int j = 0; j < y; j++)
            {
                for (int k = 0; k < x; k++)
                {
                    if (building[i][j][k] == 'S')
                        startF = i, startY = j, startX = k;
                    else if (building[i][j][k] == 'E')
                        endF = i, endY = j, endX = k;
                }
            }
        }

        queue<tuple<int, int, int, int>> q;
        q.emplace(startF, startY, startX, 0);
        building[startF][startY][startX] = '#';
        flag = 1;

        int nextF, nextY, nextX;
        while (!q.empty())
        {
            auto [curF, curY, curX, dist] = q.front();
            if (curF == endF && curY == endY && curX == endX)
            {
                cout << "Escaped in " << dist << " minute(s).\n";
                flag = 0;
                break;
            }
            q.pop();


            for (int i = 0; i < 6; i++)
            {

                nextF = curF + df[i];
                if (nextF == floor || nextF < 0)
                    continue;

                nextY = curY + dy[i];
                if (nextY == y || nextY < 0)
                    continue;
                
                nextX = curX + dx[i];
                if (nextX == x || nextX < 0 || building[nextF][nextY][nextX] == '#')
                    continue;
                
                q.emplace(nextF, nextY, nextX, dist + 1);
                building[nextF][nextY][nextX] = '#';
            }
        }

        if (flag)
            cout << "Trapped!\n";

        cin >> floor >> y >> x;
    }
    

    return 0;
}