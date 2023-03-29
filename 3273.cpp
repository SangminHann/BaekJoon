#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int *arr, n, x, cnt = 0, a = 0, b;

	cin >> n;
	arr = new int[n];
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	cin >> x;

	sort(arr, arr + n);
	b = n - 1;
	while (a < b)
	{
		if (arr[a] + arr[b] <= x)
		{
			if (arr[a] + arr[b] == x)
				++cnt;
			++a;
		}

		else if (arr[a] + arr[b] > x)
			--b;
	}
	cout << cnt;
	return 0;
}