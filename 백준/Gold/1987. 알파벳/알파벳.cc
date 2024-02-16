#include <iostream>
#define MAX(a, b) ((a) > (b) ? (a) : (b))

using namespace std;

char board[20][20], visited[26] = {0};
int x, y, maxRst = 0, dy[4] = {0, 0, 1, -1}, dx[4] = {1, -1, 0, 0};

void backTracking(int curX, int curY, int cnt)
{
    int nextX, nextY;

    for (int i = 0; i < 4; i++)
    {
        nextX = curX + dx[i];
        if (nextX < 0 || nextX == x)
            continue;

        nextY = curY + dy[i];
        if (nextY < 0 || nextY == y || visited[board[nextY][nextX] - 'A'])
            continue;

        visited[board[nextY][nextX] - 'A'] = 1;
        backTracking(nextX, nextY, cnt + 1);
        visited[board[nextY][nextX] - 'A'] = 0;
    }

    maxRst = MAX(maxRst, cnt);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> y >> x;
    for (int i = 0; i < y; i++)
        cin >> board[i];

    visited[board[0][0] - 'A'] = 1;
    backTracking(0, 0, 1);
    cout << maxRst;

    return 0;
}