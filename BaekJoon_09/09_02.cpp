#include <iostream>

using namespace std;
int Fibonacci(int input);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int input = 0;

	cin >> input;
	cout << Fibonacci(input)<<'\n';

	return (0);
}

int Fibonacci(int input)
{
	if (input == 1)
		return 1;
	if (input == 0)
		return 0;
	return (Fibonacci(input - 2) + Fibonacci(input - 1));
}

