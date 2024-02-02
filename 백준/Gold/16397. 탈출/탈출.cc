#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n, t, g, flag = -1;
    char visited[100000] = {0, };
    cin >> n >> t >> g;

    queue<tuple<int, int>> q;
    q.emplace(n, 0);
    visited[n] = 1;

    int next;
    while (!q.empty())
    {
        auto [cur, dist] = q.front();
        q.pop();
        if (dist > t)
            continue;

        if (cur == g)
        {
            flag = dist;
            break;
        }
        
        next = cur + 1;
        if (next > 99999)
            continue;
            
        if (visited[next] != 1)
        {
            visited[next] = 1;
            q.emplace(next, dist + 1);
        }

        next = --next * 2;
        if (next > 99999 || !next)
            continue;
        
        int tmp = next / 10, digit = 1;

        while (tmp)
        {
            tmp /= 10;
            digit *= 10;
        }
        next -= digit;
        
        if (visited[next])
            continue;
        
        visited[next] = 1;
        q.emplace(next, dist + 1);
    }
    flag != -1 ? (cout << flag) : (cout << "ANG");

    return 0;
}