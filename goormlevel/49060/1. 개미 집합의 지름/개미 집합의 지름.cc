#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
	int n, d, maxValue = 0, s = 0, e = 1;
	cin >> n >> d;
	
	vector<int> num(n);
	for (auto &a : num)
		cin >> a;
	
	sort(num.begin(), num.end());
	
	while (e < n)
	{
		if (num[e] - num[s] > d)
		{
				if (++s == e)
					++e;
		}
		else
		{
			if (maxValue < e - s + 1)
				maxValue = e - s + 1;
			++e;	
		}
	}
	
	cout << n - maxValue;
	
	return 0;
}