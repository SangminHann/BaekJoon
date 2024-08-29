#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int piece[6];

	for (int i = 0; i < 6; i++)
		cin >> piece[i];
	cout << 1 - piece[0] << " ";
	cout << 1 - piece[1] << " ";
	cout << 2 - piece[2] << " ";
	cout << 2 - piece[3] << " ";
	cout << 2 - piece[4] << " ";
	cout << 8 - piece[5] << " ";

	return 0;
}