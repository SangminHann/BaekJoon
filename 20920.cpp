#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

bool comp(pair<string, int> &a, pair<string, int> &b)
{
	if (a.second != b.second)
		return a.second > b.second;
	if (a.first.length() != b.first.length())
		return a.first.length() > b.first.length();
	return a.first < b.first;
}

int main()
{
	map<string, int> sMap;
	vector<pair<string, int>> rst;
	pair<map<string, int>::iterator, bool> p;
	string tmp;
	int len, n;

	cin >> n >> len;
	while (n--)
	{
		cin >> tmp;
		if (tmp.length() >= len)
		{
			p = sMap.emplace(tmp, 1);
			if (!p.second)
				sMap[tmp]++;
		}
	}

	copy(sMap.begin(), sMap.end(), back_inserter(rst));
	sort(rst.begin(), rst.end(), comp);
	for (auto &a : rst)
		cout << a.first << "\n";
	return 0;
}