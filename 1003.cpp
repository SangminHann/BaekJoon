#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int zero[41], one[41], t, num;

	zero[0] = one[1] = 1;
	one[0] = zero[1] = 0;

	cin >> t;
	while (t--)
	{
		cin >> num;
		for (int i = 2; i <= num; i++)
		{
			zero[i] = zero[i - 2] + zero[i - 1];
			one[i] = one[i - 2] + one[i - 1];
		}
		cout << zero[num] << " " << one[num] << "\n";
	}

	return 0;
}

