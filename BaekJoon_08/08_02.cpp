#include <iostream>

using namespace std;
int is_prime(int input);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int start, end, min = -1, rst = 0;

	cin >> start >> end;
	for (int i = start; i <= end; i++)
		if (is_prime(i))
		{
			min = i;
			break;
		}
	if (min == -1)
	{
		cout << min;
		return (0);
	}
	for (int i = start; i <= end; i++)
		if (is_prime(i))
			rst += i;
	cout << rst << '\n' << min;

	return (0);
}

int is_prime(int input)
{
	int cnt = 0;
	for (int i = 2; i * i <= input; i++)
		if (!(input % i))
			cnt++;
	if (cnt || input == 1)
		return (0);
	return (1);
}