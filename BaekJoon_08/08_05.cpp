#include <iostream>

using namespace std;
int is_prime(int input);

int main()
{
	int input, end, cnt;

	cin >> input;
	while (input)
	{
		end = input * 2; cnt = 0;
		for (int i = input + 1; i <= end; i++)
			if (is_prime(i))
				cnt++;
		cout << cnt << '\n';
		cin >> input;
	}

	return (0);
}

int is_prime(int input)
{
	for (int i = 2; i * i <= input; i++)
		if (!(input % i))
			return (0);
	if (input == 1)
		return (0);
	return (1);
}