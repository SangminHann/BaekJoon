#include <iostream>
#include <vector>

using namespace std;

char num[10][5][4]= {
    {
        "###",
        "#.#",
        "#.#",
        "#.#",
        "###"},
    {
        "..#",
        "..#",
        "..#",
        "..#",
        "..#"},
    {
        "###",
        "..#",
        "###",
        "#..",
        "###"},
    {
        "###",
        "..#",
        "###",
        "..#",
        "###"},
    {
        "#.#",
        "#.#",
        "###",
        "..#",
        "..#"},
    {
        "###",
        "#..",
        "###",
        "..#",
        "###"},
    {
        "###",
        "#..",
        "###",
        "#.#",
        "###"},
    {
        "###",
        "..#",
        "..#",
        "..#",
        "..#"},
    {
        "###",
        "#.#",
        "###",
        "#.#",
        "###"},
    {
        "###",
        "#.#",
        "###",
        "..#",
        "###"}};

vector<string> displayBoard(5);
double sum = 0, cnt, arr[10], tmp;
int n, e;

int check(int a, int x)
{
    int maxX = x + 3;

    for (int i = 0; i < 5; i++)
        for (int j = x, k = 0; j < maxX; j++, k++)
            if (num[a][i][k] == '.' && displayBoard[i][j] == '#')
                return 0;

    return 1;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    e = n * 4 - 1;
    for (int i = 0; i < 5; i++)
        cin >> displayBoard[i];
    
    for (int i = 0; i < e; i += 4)
    {
        tmp = cnt = 0;
        for (int j = 0; j < 10; j++)
        {
            if (check(j, i))
            {
                ++cnt;
                tmp += j;
            }
        }
        sum *= 10;
        if (cnt)
            sum += (tmp / cnt);
        else
        {
            cout << -1;
            return 0;
        }
    }

    cout.precision(5);
    cout << fixed << sum;

    return 0;
}