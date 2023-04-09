#include <iostream>
#include <set>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int a, b, tmp;
	set<int> aSet, bSet;
	vector<int> symmetricDiff;

	cin >> a >> b;
	for (int i = 0; i < a; i++)
	{
		cin >> tmp;
		aSet.insert({tmp});
	}
	for (int i = 0; i < b; i++)
	{
		cin >> tmp;
		bSet.insert({tmp});
	}
	set_symmetric_difference(aSet.begin(), aSet.end(), bSet.begin(), bSet.end(), back_inserter(symmetricDiff));
	cout << symmetricDiff.size();

	return 0;
}
