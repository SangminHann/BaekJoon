#include <iostream>

using namespace std;
int combination(int n, int r);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int rst, floor, room, num;

	cin >> num;
	while (num--)
	{
		cin >> floor >> room; 
		floor += 1; room -= 1;
		rst = combination(floor + room, floor);
		cout << rst << '\n';
	}

	return (0);
}

int combination(int n, int r)
{
	if (n == r || r == 0)
		return (1);
	return combination(n - 1, r - 1) + combination(n - 1, r);
}