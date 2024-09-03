#include <iostream>

using namespace std;

int** alloc(int n, int m)
{
	int** arr;
	arr = new int* [n];
	for (int i = 0; i < n; i++)
		arr[i] = new int[m];

	return arr;
}

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int** a, ** b, n, m, z;
	cin >> n >> m;

	a = alloc(n, m);
	b = alloc(n, m);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> a[i][j];

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> b[i][j];

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cout << a[i][j] + b[i][j] << " ";
		cout << endl;
	}
}