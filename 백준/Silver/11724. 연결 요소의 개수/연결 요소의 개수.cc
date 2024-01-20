#include <iostream>
#include <vector>

using namespace std;
void dfs(vector<vector<int>> &edge, int *&visited, int i)
{
    if (visited[i])
        return;
    visited[i] = 1;
    for (auto &a : edge[i])
        dfs(edge, visited, a);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n, m, tmp1, tmp2, cnt = 0;
    cin >> n >> m;

    vector<vector<int>> edge(n + 1);
    int *visited = new int[n + 1] {0};

    for (int i = 0; i < m; i++)
    {
        cin >> tmp1 >> tmp2;
        edge[tmp1].emplace_back(tmp2);
        edge[tmp2].emplace_back(tmp1);
    }

    for (int i = 1; i <= n; i++)
    {
        if (!visited[i])
        {
            dfs(edge, visited, i);
            ++cnt;
        }
    }

    cout << cnt;

    return 0;
}