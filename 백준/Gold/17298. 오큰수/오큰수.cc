#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    vector<int> num(n), answer(n, -1);
    for (auto &a : num)
        cin >> a;

    stack<int> s;
    for (int i = 0; i < n; i++)
    {
        while(!s.empty() && num[s.top()] < num[i])
        {
            answer[s.top()] = num[i];
            s.pop();
        }
        s.emplace(i);
    }

    for (auto &a : answer)
        cout << a << ' ';

    return 0;
}