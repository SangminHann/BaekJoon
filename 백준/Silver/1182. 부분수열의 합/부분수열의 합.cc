#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> candidate;
int n;

void combination(vector<int> &arr, int depth, int cur = 0, int start = 0)
{
    if (cur == depth)
    {
        candidate.push_back(arr);
        return ;
    }

    for (int i = start; i < n; i++)
    {
        arr[cur] = i;
        combination(arr, depth, cur + 1, i + 1);
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int squence[20], s, sum, cnt;
    cin >> n >> s;
    for (int i = 0; i < n; i++)
        cin >> squence[i];

    for (int i = 1; i <= n; i++)
    {
        vector<int> arr(i);
        combination(arr, i);
    }

    cnt = 0;
    for (auto &a : candidate)
    {
        sum = 0;
        for (auto &b : a)
            sum += squence[b];
        if (s == sum)
            ++cnt;
    }

    cout << cnt;

    return 0;
}