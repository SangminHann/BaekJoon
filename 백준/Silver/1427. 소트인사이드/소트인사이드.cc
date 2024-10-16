#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	string num;

	cin >> num;
	sort(num.rbegin(),num.rend());
	cout << num;

	return 0;
}