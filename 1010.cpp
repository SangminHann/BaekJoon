#include <iostream>

using namespace std;
int** alloc(int n);
int combination(int n, int k);

int main()
{
	int n, k, num;

	cin >> num;
	while (num--)
	{
		cin >> n >> k;
		cout << combination(k, n) << '\n';
	}
	
	return 0;
}

int combination(int n, int k)
{
	int** arr, rst;

	arr = alloc(n + 1);

	for (int i = 0; i <= n; i++)
		for (int j = 0; j <= i; j++)
		{
			if (i == j || j == 0)
				arr[i][j] = 1;
			else
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
		}

	rst = arr[n][k];
	for (int i = 0; i < n + 1; i++)
		delete arr[i];
	delete[] arr;

	return rst;
}

int** alloc(int n)
{
	int** arr;

	arr = new int* [n];
	for (int i = 0; i < n; i++)
		arr[i] = new int[n];

	return arr;
}
