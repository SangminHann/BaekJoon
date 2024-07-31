#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	vector<int> input; int num, tmp;

	cin >> num;
	for (int i = 0; i < num; i++)
	{
		cin >> tmp;
		input.push_back(tmp);
	}
	sort(input.begin(), input.end());
	for (int i = 0; i < num; i++)
		cout << input[i] << '\n';
}