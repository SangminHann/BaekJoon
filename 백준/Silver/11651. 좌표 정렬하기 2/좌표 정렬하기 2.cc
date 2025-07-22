#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
bool compare(const pair<int, int>& a, const pair<int, int>& b);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	vector<pair<int, int>> coordinate; int x, y, input;

	cin >> input;
	for (int i = 0; i < input; i++)
	{
		cin >> x >> y;
		coordinate.push_back(make_pair(x, y));
	}
	sort(coordinate.begin(), coordinate.end(), compare);
	for (int i = 0; i < input; i++)
		cout << coordinate[i].first << " " << coordinate[i].second << '\n';

	return 0;
}

bool compare(const pair<int, int>& a, const pair<int, int>& b)
{
	if (a.second == b.second)
		return a.first < b.first;
	return a.second < b.second;
}