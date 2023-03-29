#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int x, y, w, h, min;

	cin >> x >> y >> w >> h;
	min = x - 0;
	if (y - 0 < min)
		min = y - 0;
	if (w - x < min)
		min = w - x;
	if (h - y < min)
		min = h - y;
	cout << min;

	return 0;
}