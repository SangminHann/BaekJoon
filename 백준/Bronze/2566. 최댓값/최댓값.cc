#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);

	int max = 0, n = 1, m = 1, a;

	for(int i=0;i<9;i++)
		for (int j = 0; j < 9; j++)
		{
			cin >> a;
			if (max < a)
			{
				max = a;
				n = i + 1;
				m = j + 1;
			}
		}
	cout << max << '\n' << n << " " << m;
}