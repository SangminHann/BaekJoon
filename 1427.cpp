#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string num;
	int sort[10] = {0};

	cin >> num;
	for (int i = 0; i < num.size(); i++)
		sort[num[i] - '0']++;
	for (int i = 9; i >= 0; i--)
		for (int j = sort[i]; j > 0; j--)
			cout << i;

	return 0;
}