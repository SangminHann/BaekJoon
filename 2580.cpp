#include <iostream>
#include <vector>

using namespace std;

int board[9][9];
vector<pair<int,int>> coor;
int flag;

void printBoard()
{
	for (int y = 0; y < 9; y++)
	{
		for (int x = 0; x < 9; x++)
		{
			cout << board[y][x] << " ";
		}
		cout << "\n";
	}
}

int isRule(int y, int x)
{
	for (int i = 0; i < 9; i++)
	{
		if (board[y][x] == board[y][i] && i != x)
			return 0;
		if (board[y][x] == board[i][x] && i != y)
			return 0;
	}

	int scopeX = (x / 3) * 3, scopeY = (y / 3) * 3, maxX = scopeX + 3, maxY = scopeY + 3;
	
	for (int i = scopeY; i < maxY; i++)
		for (int j = scopeX; j < maxX; j++)
			if ((i != y || j != x) && board[i][j] == board[y][x])
				return 0;
	
	return 1;
}

void sudoku(int n)
{
	if (n == coor.size())
	{
		//printBoard();
		flag = 1;
		return;
	}

	for (int i = 1; i <= 9; i++)
	{
		board[coor[n].first][coor[n].second] = i;
		if (isRule(coor[n].first, coor[n].second))
			sudoku(n + 1);
	}

	if (flag)
		return;

	board[coor[n].first][coor[n].second] = 0;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	flag = 0;
	for (int y = 0; y < 9; y++)
	{
		for (int x = 0; x < 9; x++)
		{
			cin >> board[y][x];
			if (board[y][x] == 0)
				coor.push_back({y,x});
		}
	}

	sudoku(0);
	cout <<endl;
    printBoard();
	return 0;
}
