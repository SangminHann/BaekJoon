#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int rec[100][100] = {0};
int x, y, dx[4] = {0, 0, -1, 1}, dy[4] = {1, -1, 0, 0}, tmpRoomSize;

void dfs(int curY, int curX)
{
    if (curY == y || curX == x || curX < 0 || curY < 0)
        return ;
    if (rec[curY][curX])
        return ;

    rec[curY][curX] = 1;
    ++tmpRoomSize;
    for (int i = 0; i < 4; i++)
        dfs(curY + dy[i], curX + dx[i]);

}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int x1, x2, y1, y2, T, cnt = 0;
    cin >> y >> x >> T;

    vector<int> roomSize;
    roomSize.reserve(50);

    while (T--)
    {
        cin >> x1 >> y1 >> x2 >> y2;
        for (int i = y1; i < y2; i++)
            for (int j = x1; j < x2; j++)
                rec[i][j] = 1;
    }

    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            if (!rec[i][j])
            {
                tmpRoomSize = 0;
                ++cnt;
                dfs(i, j);
                roomSize.emplace_back(tmpRoomSize);
            }
        }
    }

    sort(roomSize.begin(), roomSize.end());
    cout << cnt << '\n';
    for (auto &a : roomSize)
        cout << a << " ";

    return 0;
}