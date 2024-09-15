#include <iostream>

using namespace std;
int fibonacci(int input);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int input;

	cin >> input;
	cout << fibonacci(input) << '\n';

	return (0);
}

int fibonacci(int input)
{
	if (input <= 1)
		return (1);
	return (input * fibonacci(input - 1));
}