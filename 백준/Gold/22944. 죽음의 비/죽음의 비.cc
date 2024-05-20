#include <iostream>
#include <tuple>
#include <vector>
#include <queue>

using namespace std;

typedef struct s_state
{
    int y;
    int x;
    int dist;
    int health;
    int duration;
} state;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, h, d, sx = -1, sy, dy[4] = {1, -1, 0, 0}, dx[4] = {0, 0, -1, 1};
    cin >> n >> h >> d;

    vector<string> deathLand(n);
    vector<vector<int>> visited(n, vector<int>(n, 0));
    for (auto &a : deathLand)
        cin >> a;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (deathLand[i][j] == 'S')
            {
                sy = i;
                sx = j;
                break;
            }
        }
        if (sx != -1)
            break;
    }

    queue<state> q;
    q.emplace(state{sy, sx, 0, h, 0});
    visited[sy][sx] = h;

    state cur, next;
    while (!q.empty())
    {
        cur = q.front();
        q.pop();
   
        for (int i = 0; i < 4; i++)
        {
            next = cur;
            next.x += dx[i];
            if (next.x == -1 || next.x == n)
                continue;

            next.y += dy[i];
            if (next.y == -1 || next.y == n)
                continue;

            if (deathLand[next.y][next.x] == 'U')
                next.duration = d;
            
            if (deathLand[next.y][next.x] != 'E')  
                (next.duration) ? --next.duration : --next.health;
            else
            {
                cout << ++next.dist;
                return 0;
            }

            if (!next.health)
                continue;

            if (visited[next.y][next.x] >= next.health + next.duration)
                continue;

            ++next.dist;
            visited[next.y][next.x] = next.health + next.duration;
            
            q.emplace(next);
        }
    }
    cout << -1;
    
    return 0;
}