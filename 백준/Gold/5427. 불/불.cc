#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t, dy[4] = {0, 0, -1, 1}, dx[4] = {1, -1, 0, 0};
    cin >> t;

    while (t--)
    {
        int y, x, flag = 0;
        cin >> x >> y;

        vector<string> building(y);
        for (int i = 0; i < y; i++)
            cin >> building[i];

        queue<tuple<int, int, int>> sangeun;
        queue<tuple<int, int>> fire;
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                if (building[i][j] == '*')
                    fire.emplace(i, j);
                else if (building[i][j] == '@')
                    sangeun.emplace(i, j, 0);
            }
        }
        
        int nextX, nextY;
        while (!sangeun.empty())
        {
            int sangeunQsize = sangeun.size(), fireQsize = fire.size();

            for (int j = 0; j < fireQsize; j++)
            {
                auto [fireY, fireX] = fire.front();
                fire.pop();

                for (int i = 0; i < 4; i++)
                {
                    nextX = fireX + dx[i];
                    if (nextX == x || nextX < 0)
                        continue;

                    nextY = fireY + dy[i];
                    if (nextY == y || nextY < 0 || building[nextY][nextX] == '*' || building[nextY][nextX] == '#')
                        continue;

                    fire.emplace(nextY, nextX);
                    building[nextY][nextX] = '*';
                }
            }

            for (int j = 0; j < sangeunQsize; j++)
            {
                auto [sangY, sangX, sec] = sangeun.front();
                sangeun.pop();

                for (int i = 0; i < 4; i++)
                {
                    nextX = sangX + dx[i];
                    if (nextX == x || nextX < 0)
                    {
                        cout << sec + 1 << '\n';
                        flag = 1;
                        break;
                    }

                    nextY = sangY + dy[i];
                    if (nextY == y || nextY < 0)
                    {
                        cout << sec + 1 << '\n';
                        flag = 1;
                        break;
                    }
                    if (building[nextY][nextX] == '*' || building[nextY][nextX] == '#' || building[nextY][nextX] == '@')
                        continue;

                    sangeun.emplace(nextY, nextX, sec + 1);
                    building[nextY][nextX] = '@';
                }
                if (flag)
                    break;
            }
            if (flag)
                break;
        }
        if (!flag)
            cout << "IMPOSSIBLE\n";
    }

    return 0;
}