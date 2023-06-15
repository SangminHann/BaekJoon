#include <iostream>
#include <set>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	set<string> enterance;
	string name, state;
	int t;

	cin >> t;
	while (t--)
	{
		cin >> name >> state;
		if (state == "enter")
			enterance.insert(name);
		else
			enterance.erase(name);
	}

	auto it = enterance.end();
	while (it-- != enterance.begin())
		cout << *it << '\n';
	return 0;
}