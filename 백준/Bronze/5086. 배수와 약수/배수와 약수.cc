#include <iostream>

using namespace std;

int main()
{
	int first, second;

	while (true)
	{
		cin >> first >> second;
		if (!first)
			break;
		if (first % second == 0)
			cout << "multiple\n";
		else if (second % first == 0)
			cout << "factor\n";
		else
			cout << "neither\n";
	}

	return 0;
}