#include <iostream>

using namespace std;

int main()
{
	long long cnt = 0;
	string a, b;

	cin >> a >> b;
	for (int i = 0; i < (int)a.length(); i++)
	{
		for (int j = 0; j < (int)b.length(); j++)
			cnt += (a[i] - '0') * (b[j] - '0');
	}
	cout << cnt;
}