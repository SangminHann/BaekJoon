#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, maxValue = 0;

vector<vector<int>> moveUp(vector<vector<int>> b)
{
    vector<vector<int>> rst(n, vector<int>(n, 0));
    queue<int> q;
    int idx;

    for (int i = 0; i < n; i++)
    {
        idx = 0;

        for (int j = 0; j < n; j++)
        {
            if (b[j][i])
                q.emplace(b[j][i]);
        }

        while (!q.empty())
        {
            if (!rst[idx][i])
            {
                rst[idx][i] = q.front();
                q.pop();
            }
            else if (rst[idx][i] == q.front())
            {
                rst[idx++][i] += q.front();
                q.pop();
            }
            else
                ++idx;
        }
    }

    return rst;
}

vector<vector<int>> moveDown(vector<vector<int>> b)
{
    vector<vector<int>> rst(n, vector<int>(n, 0));
    queue<int> q;
    int idx;

    for (int i = 0; i < n; i++)
    {
        idx = n - 1;

        for (int j = n - 1; j >= 0; j--)
        {
            if (b[j][i])
                q.emplace(b[j][i]);
        }

        while (!q.empty())
        {
            if (!rst[idx][i])
            {
                rst[idx][i] = q.front();
                q.pop();
            }
            else if (rst[idx][i] == q.front())
            {
                rst[idx--][i] += q.front();
                q.pop();
            }
            else
                --idx;
        }
    }

    return rst;
}

vector<vector<int>> moveLeft(vector<vector<int>> b)
{
    vector<vector<int>> rst(n, vector<int>(n, 0));
    queue<int> q;
    int idx;

    for (int i = 0; i < n; i++)
    {
        idx = 0;

        for (int j = 0; j < n; j++)
        {
            if (b[i][j])
                q.emplace(b[i][j]);
        }

        while (!q.empty())
        {
            if (!rst[i][idx])
            {
                rst[i][idx] = q.front();
                q.pop();
            }
            else if (rst[i][idx] == q.front())
            {
                rst[i][idx++] += q.front();
                q.pop();
            }
            else
                ++idx;
        }
    }

    return rst;
}

vector<vector<int>> moveRight(vector<vector<int>> b)
{
    vector<vector<int>> rst(n, vector<int>(n, 0));
    queue<int> q;
    int idx;

    for (int i = 0; i < n; i++)
    {
        idx = n - 1;

        for (int j = n - 1; j >= 0; j--)
        {
            if (b[i][j])
                q.emplace(b[i][j]);
        }

        while (!q.empty())
        {
            if (!rst[i][idx])
            {
                rst[i][idx] = q.front();
                q.pop();
            }
            else if (rst[i][idx] == q.front())
            {
                rst[i][idx--] += q.front();
                q.pop();
            }
            else
                --idx;
        }
    }

    return rst;
}

void recursive(int idx, vector<vector<int>> board)
{
    if (idx == 5)
    {
        for (auto &a : board)
        {
            for (auto &b : a)
            {
                if (maxValue < b)
                    maxValue = b;
            }
        }

        return ;
    }

    vector<vector<int>> tmp;

    tmp = moveUp(board);
    recursive(idx + 1, tmp);

    tmp = moveDown(board);
    recursive(idx + 1, tmp);

    tmp = moveLeft(board);
    recursive(idx + 1, tmp);

    tmp = moveRight(board);
    recursive(idx + 1, tmp);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    vector<vector<int>> board(n, vector<int>(n)), tmp;

    for (auto &a : board)
        for (auto &b : a)
            cin >> b;

    recursive(0, board);
    cout << maxValue;

    return 0;
}