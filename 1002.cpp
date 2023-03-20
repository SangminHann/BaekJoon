#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int a[3], b[3], t;

	cin >> t;
	while (t--)
	{
		cin >> a[0] >> a[1] >> a[2] >> b[0] >> b[1] >> b[2];
		if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2])
		{
			cout << "-1\n";
			continue;
		}
		int d = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
		if ((a[2] + b[2]) * (a[2] + b[2]) == d || (a[2] - b[2]) * (a[2] - b[2]) == d)
			cout << "1\n";
		else if ((a[2] + b[2]) * (a[2] + b[2]) < d || (a[2] - b[2]) * (a[2] - b[2]) > d)
			cout << "0\n";
		else
			cout << "2\n";
	}
}
