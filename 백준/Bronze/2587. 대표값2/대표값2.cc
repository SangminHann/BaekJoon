#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	vector<int> a;
	int tmp;
	for (int i = 0; i < 5; i++)
	{
		cin >> tmp;
		a.push_back(tmp);
	}
	sort(a.begin(), a.end()); tmp = 0;
	for (int i = 0; i < 5; i++)
		tmp += a[i];
	tmp /= 5;
	cout << tmp << '\n' << a[2];
}