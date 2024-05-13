#include <string>
#include <vector>

using namespace std;

int *visited;

void dfs(vector<vector<int>> &computers, int n, int idx)
{
    visited[idx] = 1;
    
    for (int i = 0; i < n; i++)
    {
        if (i != idx && computers[idx][i] && !visited[i])
        {
            visited[i] = 1;
            dfs(computers, n, i);
        }
    }
}

int solution(int n, vector<vector<int>> computers)
{
    int answer = 0;
    visited = new int[n]{0};
    
    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
        {
            dfs(computers, n, i);
            ++answer;
        }
    }
    
    return answer;
}