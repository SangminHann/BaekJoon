#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int t, x, sY, sX, eY, eX, dx[8] = {-2, -2, -1, -1, 1, 1, 2, 2}, dy[8] = {1, -1, 2, -2, 2, -2, 1, -1};

    cin >> t;
    while (t--)
    {
        cin >> x;
        vector<vector<int>> board(x, vector<int>(x, 0));

        cin >> sY >> sX;
        cin >> eY >> eX;

        queue<tuple<int, int, int>> q;
        q.emplace(sY, sX, 0);
        board[sY][sX] = 1;

        int nextY, nextX;
        while(!q.empty())
        {
            auto [curY, curX, dist] = q.front();
            if (curY == eY && curX == eX)
            {
                cout << dist << '\n';
                break;
            }
            q.pop();

            for (int i = 0; i < 8; i++)
            {
                nextY = curY + dy[i];
                if (nextY < 0 || nextY >= x)
                    continue;

                nextX = curX + dx[i];
                if (nextX < 0 || nextX >= x || board[nextY][nextX] == 1)
                    continue;

                q.emplace(nextY, nextX, dist + 1);
                board[nextY][nextX] = 1;
            }
        }
    }
    

    return 0;
}