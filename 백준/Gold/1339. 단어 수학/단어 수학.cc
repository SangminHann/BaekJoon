#include <iostream>
#define MAX(x, y) ((x) > (y) ? (x) : (y))

using namespace std;

int num[10] = {0}, alpha[26], isUsed[26] = {0, }, n, maxSum = 0, alphaNum = 0;
string word[10];

void backTracking(int idx, int cnt)
{
    if (cnt == alphaNum)
    {
        int sum = 0, tmp = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < word[i].length(); j++)
                tmp = tmp * 10 + alpha[word[i][j] - 'A'];
            sum += tmp;
            tmp = 0;
        }
        maxSum = MAX(maxSum, sum);

        return ;
    }

    if (!isUsed[idx])
    {
        backTracking(idx + 1, cnt);
        return;
    }

    for (int i = 9; i >= 0; i--)
    {
        if (num[i])
            continue;

        num[i] = 1;
        alpha[idx] = i;
        backTracking(idx + 1, cnt + 1);
        num[i] = 0;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> word[i];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < word[i].length(); j++)
            isUsed[word[i][j] - 'A'] = 1;

    for (int i = 0; i < 26; i++)
        if (isUsed[i])
            ++alphaNum;
    
    backTracking(0, 0);
    cout << maxSum;

    return 0;
}