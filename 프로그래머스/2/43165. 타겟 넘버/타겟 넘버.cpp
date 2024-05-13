#include <string>
#include <vector>

using namespace std;

int cnt = 0;

void dfs(vector<int> &numbers, int target, int idx, int sum)
{
    if (idx == (int) numbers.size())
    {
        if (target == sum)
            ++cnt;
        return ;
    }
    
    dfs(numbers, target, idx + 1, sum + numbers[idx]);
    dfs(numbers, target, idx + 1, sum + (numbers[idx] * -1));
}

int solution(vector<int> numbers, int target)
{
    dfs(numbers, target, 0, 0);

    return cnt;
}