#include <iostream>

using namespace std;
int factorization(int* input);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int input;
	
	cin >> input;
	while (input != 1)
		cout << factorization(&input) << '\n';

	return (0);
}

int factorization(int* input)
{
	int i = 2;

	for (; i <= *input; i++)
		if (!(*input % i))
			break;
	*input /= i;

	return (i);
}