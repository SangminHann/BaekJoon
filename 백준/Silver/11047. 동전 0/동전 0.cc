#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	vector<int> coin;
	int sum, num, cnt = 0;

	cin >> num >> sum;

	coin.resize(num);
	for (int i = 0; i < num; i++)
		cin >> coin[i];

	while (num--)
	{
		cnt += (sum / coin[num]);
		sum %= coin[num];
	}

	cout << cnt;
	return 0;
}