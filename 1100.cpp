#include <iostream>

using namespace std;

int main()
{
	string s;
	int cnt = 0;

	for (int i = 0; i < 8; i++)
	{
		cin >> s;
		for (int j = 0; j < 8; j++)
		{
			if (i % 2 == j % 2 && s[j] == 'F')
				cnt++;
		}
	}
	cout << cnt;
}