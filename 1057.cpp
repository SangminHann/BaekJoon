#include <iostream>

using namespace std;

int next_round(int x)
{
	if (x % 2)
		++x;
	return (x / 2);
}

int is_match(int x, int y)
{
	return ((x % 2) && (y == (x + 1)));
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, x, y, tmp, cnt = 1;
	cin >> n >> x >> y;

	if (x > y)
	{
		tmp = x;
		x = y;
		y = tmp;
	}

	while (!is_match(x, y))
	{
		x = next_round(x);
		y = next_round(y);
		++cnt;
	}

	cout << cnt;
}
