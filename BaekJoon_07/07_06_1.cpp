#include <iostream>

using namespace std;
int combination(int n, int r); //dp·Î °³¼±

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int rst, floor, room, num;

	cin >> num;
	while (num--)
	{
		cin >> floor >> room;
		floor += 1; room -= 1;
		rst = combination(floor + room, floor);
		cout << rst << '\n';
	}

	return (0);
}

int combination(int n, int r)
{
	int** comb = new int* [n + 1]; int rst;
	for (int i = 0; i < n + 1; i++)
		comb[i] = new int[i + 1];
	for (int i = 0; i < n + 1; i++) 
		for (int j = 0; j <= i && j < r + 1; j++) 
		{
			if (i == j || j == 0) comb[i][j] = 1;
			else comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
		}
	rst = comb[n][r];
	for (int i = 0; i < n + 1; i++)
		delete[] comb[i];
	delete[] comb;

	return (rst);
}