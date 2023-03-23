#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int* a, * b, * flag, n, max, tmp, rst = 0;

	cin >> n;

	a = new int[n];
	b = new int[n];
	flag = new int[n] {0};

	for (int i = 0; i < n; i++)
		cin >> a[i];
	for (int i = 0; i < n; i++)
		cin >> b[i];

	sort(a, a + n);

	for (int i = 0; i < n; i++)
	{
		max = -1;
		for (int j = 0; j < n; j++)
		{
			if (flag[j] == 0 && max < b[j])
			{
				max = b[j];
				tmp = j;
			}
		}
		rst += (a[i] * max);
		flag[tmp] = 1;
	}
	cout << rst;

	return 0;
}
