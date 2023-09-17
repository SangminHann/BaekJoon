#include <iostream>
#include <vector>

using namespace std;

int cnt = 0, day, minWeight, contribute[3][2];

void dfs(int past, int sum, int _day)
{
	if (_day == day)
	{
		if (sum >= minWeight)
			++cnt;
		return;
	}

	for (int i=0;i<3;i++)
		for (int j = 0; j < 2; j++)
			dfs(i, sum + (contribute[i][j] / (1 + (past == i))), _day + 1);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> day >> minWeight;
	for (int i = 0; i < 3; i++)
		cin >> contribute[i][0];
	for (int i = 0; i < 3; i++)
		cin >> contribute[i][1];

	dfs(-1, 0, 0);
	cout << cnt;
}