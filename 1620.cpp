#include <iostream>
#include <map>
#include <string>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	map<string, int> pokeMon;
	map<int, string> serialNo;
	int num[2];
	string tmp;

	cin >> num[0] >> num[1];
	for (int i = 0; i < num[0]; i++)
	{
		cin >> tmp;
		pokeMon.insert({tmp, i + 1});
		serialNo.insert({i + 1, tmp});
	}
	for (int i = 0, no; i < num[1]; i++)
	{
		cin >> tmp;
		if (tmp[0] > '0' && tmp[0] <= '9')
			cout << serialNo.at(stoi(tmp));
		else
			cout << pokeMon.at(tmp);
		cout << '\n';
	}
}