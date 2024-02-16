#include <iostream>

using namespace std;

string maze[5];
int k, r, c, cnt = 0;
int dx[4] = {0 , 0, -1, 1}, dy[4] = {1, -1, 0, 0};

void backTracking(char i, int y, int x)
{
    if (i == (char)k)
    {
        if (maze[0][c - 1] == k)
            ++cnt;

        return ;
    }

    int nextX, nextY;
    for (int j = 0; j < 4; j++)
    {
        nextX = x + dx[j];
        if (nextX == c || nextX < 0)
            continue;

        nextY = y + dy[j];
        if (nextY == r || nextY < 0 || maze[nextY][nextX] != '.')
            continue;

        maze[nextY][nextX] = i + 1;
        backTracking(i + 1, nextY, nextX);
        maze[nextY][nextX] = '.';
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> r >> c >> k;
    for (int i = 0; i < r; i++)
        cin >> maze[i];

    maze[r - 1][0] = 1;
    backTracking(1, r - 1, 0);
    cout << cnt;

    return 0;
}