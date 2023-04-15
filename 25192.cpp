#include <iostream>
#include <set>

using namespace std;

int main()
{
	set<string> s;
	string tmp;
	int n, ans = 0;

	s.clear();
	cin >> n;
	while (n--)
	{
		cin >> tmp;
		if (tmp == "ENTER")
		{
			ans += s.size();
			s.clear();
		}
		else
			s.insert(tmp);
	}
	cout << ans + s.size();
	return 0;
}