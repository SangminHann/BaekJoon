#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);

	int a[100][100] = { 0 };
	int x, y, n, cnt = 0;

	cin >> n;
	while (n--)
	{
		cin >> x >> y;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				a[y - 1 + i][x - 1 + j] = 1;
	}
	for (int i = 0; i < 100; i++)
		for (int j = 0; j < 100; j++)
			if (a[i][j])
				cnt++;
	cout << cnt;
}