#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int total, type, price, num, tmp = 0;
	cin >> total >> type;
	for (int i = 0; i < type; i++)
	{
		cin >> price >> num;
		tmp += (price * num);
	}
	if (total == tmp)
		cout << "Yes";
	else
		cout << "No";

	return 0;
}