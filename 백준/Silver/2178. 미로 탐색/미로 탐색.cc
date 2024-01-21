#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m;
    int dx[4] = {0, 0, 1, -1}, dy[4] = {-1, 1, 0, 0};
    cin >> n >> m;

    vector<string> maze(n);
    vector<vector<int>> visited(n, vector<int>(m, 0));
    for (int i = 0; i < n; i++)
        cin >> maze[i];

    queue<tuple<int, int, int>> q;
    q.emplace(0, 0, 1);
    visited[0][0] = 1;

    while(!q.empty()) 
    {
        auto [y, x, dist] = q.front();
        int nextX, nextY;
        q.pop();
        
        if (y == n - 1 && x == m - 1)
        {
            cout << dist;
            break;
        }
        
        for (int i = 0; i < 4; i++) 
        {
            nextY = y + dy[i];
            if ((nextY < 0) || (nextY >= n))
                continue;
            
            nextX = x + dx[i];
            if ((nextX < 0) || (nextX >= m))
                continue;

            if (maze[nextY][nextX] == '0')
                continue;
            if (!visited[nextY][nextX])
            {
                visited[nextY][nextX] = 1;
                q.emplace(nextY, nextX, dist + 1);
            }
        }
    }


    return 0;
}