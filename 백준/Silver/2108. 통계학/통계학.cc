#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;
void arithmeticMean(vector<int> v);
void mode(vector<int> v);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	vector<int> input; int size; int tmp;

	cin >> size;
	for (int i = 0; i < size; i++)
	{
		cin >> tmp;
		input.push_back(tmp);
	}
	sort(input.begin(), input.end());
	arithmeticMean(input);
	cout << input[input.size() / 2] << '\n';
	mode(input);
	cout << input.back() - input.front() << '\n';

	return 0;
}

void arithmeticMean(vector<int> v)
{
	int sum = 0; double rst;
	for_each(v.begin(), v.end(), [&sum](auto& n) {sum += n; });
	rst = (double)sum / v.size();
	rst = round(rst);
	cout << (int)rst << '\n';
}

void mode(vector<int> v)
{
	int val[8001] = { 0 }, cnt = 0, max = 0, rst;

	for_each(v.begin(), v.end(), [&val](auto& n) {val[n + 4000]++; });
	for (int i = 0; i < 8001; i++)
	{
		if (max == val[i])
			cnt++;
		if (cnt == 1 && max == val[i])
			rst = i;
		else if (max < val[i])
		{
			cnt = 0;
			max = val[i];
			rst = i;
		}
	}

	cout << rst - 4000 << '\n';
}