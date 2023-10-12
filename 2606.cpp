#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int com, t, n1, n2, tmp, cnt = -1;
    cin >> com >> t;

    vector<vector<int>> link(com + 1);
    vector<int> visited(com + 1, 0);
    queue<int> q;

    while (t--)
    {
        cin >> n1 >> n2;
        link[n1].push_back(n2);
        link[n2].push_back(n1);
    }

    q.emplace(1);

    while (!q.empty())
    {
        tmp = q.front();
        q.pop();

        if (!visited[tmp])
        {
            visited[tmp]++;
            cnt++;

            for (auto i : link[tmp])
            {
                if (!visited[i])
                    q.emplace(i);
            }
        }
    }

    cout << cnt;

    return 0;
}