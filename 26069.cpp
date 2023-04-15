#include <iostream>
#include <set>

using namespace std;

int main()
{
	set<string> nSet;
	string tmp1, tmp2;
	int n, cnt = 0;

	cin >> n;

	nSet.insert("ChongChong");
	for (int i = 0; i < n; i++)
	{
		cin >> tmp1 >> tmp2;
		if (nSet.find(tmp1) != nSet.end())
			nSet.insert(tmp2);
		if (nSet.find(tmp2) != nSet.end())
			nSet.insert(tmp1);
	}
	cout << nSet.size();
	return 0;
}