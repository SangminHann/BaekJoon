#include <string>
#include <vector>

using namespace std;

int *uf;

int find_root(int n)
{
    if (uf[n] == n)
        return n;
    return uf[n] = find_root(uf[n]);
}

void union_find(int x, int y)
{
    int parentX, parentY;
    
    parentX = find_root(x);
    parentY = find_root(y);
    
    uf[parentY] = parentX;
}

int solution(int n, vector<vector<int>> computers)
{
    uf = new int[computers.size()];
    
    for (int i = 0; i < (int)computers.size(); i++)
        uf[i] = i;
    
    for (int i = 0; i < (int)computers.size(); i++)
        for (int j = 0; j < (int)computers.size(); j++)
            if (computers[i][j])
                union_find(i, j);
    
    for (int i = 0; i < (int)computers.size(); i++)
        find_root(i);
    
    int *network = new int[computers.size()] {0}, answer = 0;
    
    for (int i = 0; i < (int)computers.size(); i++)
        network[uf[i]] = 1;

    for (int i = 0; i < (int)computers.size(); i++)
        if (network[i])
            ++answer;

    return answer;
}