#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int>& a, pair<int, int>& b)
{
	if (a.second == b.second)
		return a.first < b.first;
	return a.second < b.second;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	vector<pair<int, int>> meeting;
	pair<int, int>tmp;
	int t, cnt = 0, endTime = 0;

	cin >> t;
	while (t--)
	{
		cin >> tmp.first >> tmp.second;
		meeting.push_back(tmp);
	}
	sort(meeting.begin(), meeting.end(), cmp);
	

	for (auto &cur : meeting)
		if (endTime <= cur.first)
		{
			++cnt;
			endTime = cur.second;
		}
	
	cout << cnt;
	return 0;
}