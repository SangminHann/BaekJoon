#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string input;
	int tmp = 0, plus = 0, minus = 0, idx = -1;

	cin >> input;

	while (++idx < input.length())
	{
		if (input[idx] == '-')
			break;
		if (input[idx] != '+')
			tmp = tmp * 10 + input[idx] - '0';
		else
		{
			plus += tmp;
			tmp = 0;
		}
	}
	plus += tmp;
	tmp = 0;
	while (++idx < input.length())
	{
		if (input[idx] != '-' && input[idx] != '+')
			tmp = tmp * 10 + input[idx] - '0';
		else
		{
			minus += tmp;
			tmp = 0;
		}
	}
	minus += tmp;

	cout << plus - minus;
	return 0;
}