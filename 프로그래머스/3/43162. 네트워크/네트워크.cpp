#include <string>
#include <vector>
#include <queue>

using namespace std;

int *visited;

void bfs(vector<vector<int>> &computers, int n, int x)
{
    queue<int> q;
    q.emplace(x);
    visited[x] = 1;
    
    while (!q.empty())
    {
        int s = q.front();
        q.pop();
        
        for (int i = 0; i < n; i++)
        {
            if (s != i && computers[s][i] && !visited[i])
            {
                q.emplace(i);
                visited[i] = 1;
            }
        }
    }  
}

int solution(int n, vector<vector<int>> computers) 
{
    int answer = 0;
    visited = new int[n] {0};
    
    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
        {
            bfs(computers, n, i);
            ++answer;
        }
    }
    
    return answer;
}