#include <iostream>

using namespace std;

string wooden[50];
int visited[50][50] = {0,};
int x, y, cnt = 0;

void goRight(int _y, int _x)
{
    if (_x == x)
    {
        ++cnt;
        return ;
    }
    if (wooden[_y][_x] == '|')
    {
        ++cnt;
        return;
    }
    visited[_y][_x] = 1;
    goRight(_y, _x + 1);
}

void goDown(int _y, int _x)
{
    if (_y == y)
    {
        ++cnt;
        return ;
    }
    if (wooden[_y][_x] == '-')
    {
        ++cnt;
        return;
    }
    visited[_y][_x] = 1;
    goDown(_y + 1, _x);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> y >> x;
    for (int i = 0; i < y; i++)
        cin >> wooden[i];

    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            if (!visited[i][j])
            {
                if (wooden[i][j] == '-')
                    goRight(i, j);
                else
                    goDown(i, j);
            }
        }
    }

    cout << cnt;

    return 0;
}