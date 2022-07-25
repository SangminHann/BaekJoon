#include <iostream>

using namespace std;
int Factorial(int input);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int input;

	cin >> input;
	cout << Factorial(input) << '\n';

	return (0);
}

int Factorial(int input)
{
	if (input <= 1)
		return (1);
	return (input * Factorial(input - 1));
}