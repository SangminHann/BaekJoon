#include <iostream>
#include <cmath>

using namespace std;

int is_valid(int board[], int num);
void findCase(int board[], int num);
int cnt, Max;

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int board[16] = { 0 };
    cnt = 0;
    cin >> Max;

    findCase(board, 1);
    cout << cnt;

    return 0;
}

int is_valid(int board[], int num)
{
    for (int i = 1; i < num; i++)
    {
        if (board[i] == board[num])
            return 0;
        if (num - i == abs(board[i] - board[num]))
            return 0;
    }
    return 1;
}

void findCase(int board[], int num)
{
    if (num > Max)
    {
        ++cnt;
        return;
    }

    for (int i = 1; i <= Max; i++)
    {
        board[num] = i;
        if (is_valid(board, num))
            findCase(board, num + 1);
    }
}
