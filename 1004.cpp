#include <iostream>

using namespace std;

int distance(int a[], int b[])
{
	return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);

}
int isInside(int r1, int r2)
{
	if (r2 * r2 > r1)
		return 1;
	return 0;
}

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int a[2], b[2], c[3], t, n;
	cin >> t;
	while (t--)
	{
		int cnt = 0;
		cin >> a[0] >> a[1] >> b[0] >> b[1];
		cin >> n;
		while (n--)
		{
			cin >> c[0] >> c[1] >> c[2];
			if (!(isInside(distance(a, c), c[2]) && isInside(distance(b, c), c[2])))
			{
				if ((isInside(distance(a, c), c[2]) || isInside(distance(b, c), c[2])))
					cnt++;
			}
		}
		cout << cnt << '\n';
	}
}
