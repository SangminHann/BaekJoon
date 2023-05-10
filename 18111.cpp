#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int maxHeigt = 0, minTime = 128000000, Time, n, m, b, tmp, start = 0, end = 256;
	int used, earned;
	int land[257] = {0};
	int cur = 0, height;

	cin >> n >> m >> b;

	n *= m;

	for (int i = 0; i < n; i++)
	{
		cin >> tmp;
		land[tmp]++;
	}

	while (!land[start])
		++start;
	while (!land[end])
		--end;

	height = start;

	while (height <= end)
	{
		used = earned = 0;
		cur = start;

		while (cur != height)
		{
			used += (height - cur) * land[cur];
			++cur;
		}

		while (++cur <= end)
			earned += (cur - height) * land[cur];

		if (earned + b < used)
			break;

		Time = (earned << 1) + used;

		if (minTime >= Time)
		{
			maxHeigt = height;
			minTime = Time;
		}
		++height;
	}

	cout << minTime << ' ' << maxHeigt;

	return 0;
}