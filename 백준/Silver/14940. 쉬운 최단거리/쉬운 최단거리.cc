#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m, targetY, targetX;
    cin >> n >> m;

    vector<vector<int>> landMap(n, vector<int>(m)), distMap(n, vector<int>(m, -1)), visited(n, vector<int>(m, 0));
    int dx[4] = {1, -1, 0, 0}, dy[4] = {0, 0, 1, -1};

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> landMap[i][j];

            if (!landMap[i][j])
                distMap[i][j] = 0;
            else if (landMap[i][j] == 2)
            {
                visited[i][j] = 1;
                distMap[i][j] = 0;
                targetY = i;
                targetX = j;
            }
        }
    }

    queue<tuple<int, int, int>> q;
    q.emplace(targetY, targetX, 0);

    while (!q.empty())
    {
        auto [y, x, dist] = q.front();
        q.pop();

        int nextX, nextY;
        for(int i = 0; i < 4; i++)
        {
            nextY = y + dy[i];
            if (nextY < 0 || nextY >= n)
                continue;
            
            nextX = x + dx[i];
            if (nextX < 0 || nextY >= m || !landMap[nextY][nextX] || visited[nextY][nextX])
                continue;
        
           visited[nextY][nextX] = 1;
           distMap[nextY][nextX] = dist + 1;
           q.emplace(nextY, nextX, dist + 1);
        }
    }
    
    for (auto i : distMap)
    {
        for (auto j : i)
            cout << j << ' ';
        cout << '\n';
    }

    return 0;
}