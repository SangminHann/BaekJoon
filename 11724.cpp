#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> graph;
vector<int> visited;

void dfs(int cur)
{
    visited[cur] = 1;
    for (auto next : graph[cur])
    {
        if (!visited[next])
            dfs(next);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    
    int n, m, u, v, cnt = 0;

    cin >> n >> m;
    graph.assign(n + 1, vector<int>(0));
    visited.assign(n + 1, 0);

    for (int i = 0; i < m; i++)
    {
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    for (int cur = 1; cur <= n; cur++)
    {
        if (!visited[cur])
        {
            dfs(cur);
            ++cnt;
        }
    }

    cout << cnt;

    return 0;
}