#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int t, docs, idx, cnt;

    cin >> t;

    while (t--)
    {
        queue<pair<int, int>> q;
        cnt = 0;

        cin >> docs >> idx;
        vector<int> importance(docs);

        for (int i = 0; i < docs; i++)
        {
            cin >> importance[i];  
            q.push({i, importance[i]});
        }

        sort(importance.begin(), importance.end());

        while (q.size())
        {
            if (importance[importance.size() - 1] > q.front().second)
            {
                q.emplace(q.front());
                q.pop();
            }

            else
            {
                ++cnt;
                if (q.front().first == idx)
                {
                    cout << cnt << "\n";
                    break;
                }
                q.pop();
                importance.pop_back();
            }
        }
    }



    return 0;
}