#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	long long n;
	cin >> n;
	cout << (n * (n - 1) * (n - 2)) / 6 << "\n3";
	return 0;
}