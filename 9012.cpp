#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t, check;
	string ps;

	cin >> t;
	while (t--)
	{
		check = 0;
		
		cin >> ps;
		for (int i = 0; i < ps.size(); i++)
		{
			if (ps[i] == '(')
				++check;
			else
				--check;
			if (check < 0)
			{
				cout << "NO\n";
				break;
			}
		}
		if (check > 0)
			cout << "NO\n";
		else if (!check)
			cout << "YES\n";
	}
	return 0;
}