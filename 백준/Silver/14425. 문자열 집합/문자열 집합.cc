#include <iostream>
#include <map>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	map<string, bool> word; int n, m, cnt = 0; string tmp;

	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		cin >> tmp;
		word.insert({ tmp, true });
	}
	for (int i = 0; i < m; i++)
	{
		cin >> tmp;
		if (word.count(tmp))
			cnt++;
	}
	cout << cnt;

	return 0;
}