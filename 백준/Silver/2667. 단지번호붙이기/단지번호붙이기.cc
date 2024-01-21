#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int dx[] = {0, 0, -1, 1}, dy[] = {1, -1, 0, 0};
int houseNum, cnt;
string house[25];

void dfs(int _x, int _y)
{
    if (_x == houseNum || _y == houseNum || _x < 0 || _y < 0)
        return;
    if (house[_y][_x] == '0')
        return;
    house[_y][_x] = '0';
    ++cnt;

    for (int i = 0; i < 4; i++)
        dfs(_x + dx[i], _y + dy[i]);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    vector<int> rst;
    rst.reserve(313);
    cin >> houseNum;

    for (int i = 0; i < houseNum; i++)
        cin >> house[i];

    for (int i = 0; i < houseNum; i++)
    {
        for (int j = 0; j < houseNum; j++)
        {
            if (house[i][j] == '1')
            {
                cnt = 0;
                dfs(j, i);
                rst.emplace_back(cnt);
            }
        }
    }

    sort(rst.begin(), rst.end());
    
    cout << rst.size() << '\n';
    for (auto &a : rst)
        cout << a << '\n';

    return 0;
}