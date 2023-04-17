#include <iostream>
#include <vector>
#include <unordered_map>
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
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	unordered_map<string, int> wordMap;
	vector<pair<string, int>> rst;
	pair<unordered_map<string, int>::iterator, bool> p;
	string tmp;
	int len, n;

	cin >> n >> len;
	while (n--)
	{
		cin >> tmp;
		if (tmp.length() >= len)
		{
			p = wordMap.emplace(tmp, 1);
			if (!p.second)
				wordMap[tmp]++;
		}
	}

	copy(wordMap.begin(), wordMap.end(), back_inserter(rst));
	sort(rst.begin(), rst.end(), comp);

	for (auto &a : rst)
		cout << a.first << "\n";

	return 0;
}