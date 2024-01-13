#include <iostream>

using namespace std;
char startB(int n, int m);
char startW(int n, int m);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int n, m, min = 64, cntB, cntW; string* chess;

	cin >> n >> m;
	chess = new string [n];
	for (int i = 0; i < n; i++)
		cin >> chess[i];
	for (int i = 0; i <= n - 8; i++)
		for (int j = 0; j <= m - 8; j++)
		{
			cntB = cntW = 0;
			for (int k = i; k < i + 8; k++)
			{
				for (int l = j; l < j + 8; l++)
					if (chess[k][l] != startB(k, l))
						cntB++;
				for (int l = j; l < j + 8; l++)
					if (chess[k][l] != startW(k, l))
						cntW++;
			}
			if (cntW < cntB)
			{
				if (cntW < min)
					min = cntW;
			}
			else if (cntB < min)
				min = cntB;
		}
	cout << min;

	return 0;
}

char startB(int n, int m) 
{
	if (n % 2 == 0)
	{
		if (m % 2 == 0)
			return 'B';
		return 'W';
	}
	if (m % 2 == 0)
		return 'W';
	return 'B';
}

char startW(int n, int m)
{
	if (n % 2 == 0)
	{
		if (m % 2 == 0)
			return 'W';
		return 'B';
	}
	if (m % 2 == 0)
		return 'B';
	return 'W';
}