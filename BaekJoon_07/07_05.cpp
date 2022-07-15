#include <iostream>


using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int n, floor, room, ordinary, rst;
	cin >> n;
	while (n--)
	{
		rst = 0;
		cin >> floor >> room >> ordinary;
		rst = (ordinary / floor) + 1;
		if (ordinary % floor)
			rst += (ordinary % floor) * 100;
		else
			rst += floor * 100 - 1;
		cout << rst << '\n';
	}

	return (0);
}