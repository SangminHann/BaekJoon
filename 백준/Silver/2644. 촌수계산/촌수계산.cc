#include <iostream>
#include <vector>

using namespace std;

int s, e, flag = 0;
void dfs(vector<vector<int>> &relative, vector<int> &visited, int n, int cnt = 1)
{
    if (visited[n])
        return ;
    visited[n] = 1;

    for (auto &a : relative[n])
    {
        if (a == e)
        {
            cout << cnt;
            flag = 1;
            return ;
        }
        dfs(relative, visited, a, cnt + 1);
        if (flag)
            return ;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int people, T, tmp1, tmp2;
    cin >> people;
    vector<vector<int>> relative(people + 1);
    vector<int> visited(people + 1, 0);

    cin >> s >> e;
    cin >> T;
    while (T--)
    {
        cin >> tmp1 >> tmp2;
        relative[tmp1].emplace_back(tmp2);
        relative[tmp2].emplace_back(tmp1);
    }

    dfs(relative, visited, s);

    if (!flag)
        cout << -1;

    return 0;
}