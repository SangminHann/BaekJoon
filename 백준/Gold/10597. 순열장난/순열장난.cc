#include <iostream>
#include <deque>

using namespace std;

int visited[51] = {1, };
string num;
deque<int> rst;

void backTracking(int idx)
{
    if (idx == (int)num.length())
    {
        for (int i = 1; i <= rst.size(); i++)
            if (!visited[i])
                return ;

        for (auto &a : rst)
            cout << a << " ";
        exit(0);
    }

    int tmp = 0, cnt = 1;

    for (int i = idx; i < (int)num.length(); i++, cnt++)
    {
        tmp = tmp * 10 + num[i] - '0';
        if (tmp > 50)
            return ;
        if (visited[tmp])
            continue;

        visited[tmp] = 1;
        rst.emplace_back(tmp);
        backTracking(idx + cnt);
        visited[tmp] = 0;
        rst.pop_back();
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> num;
    backTracking(0);

    return 0;
}