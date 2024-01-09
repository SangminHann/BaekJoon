#include <iostream>

using namespace std;
int digitSum(int num, int sum);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int min, input, tmp;

	cin >> input; min = input + 1;
	for (int i = input - 54; i < input; i++)
	{
		tmp = i + digitSum(i, 0);
		if (tmp == input && tmp < min)
		{
			min = i;
			break;
		}
	}
	if (min == input + 1)
		min = 0;
	cout << min;
}

int digitSum(int num, int sum)
{
	if (num == 0)
		return sum;
	return digitSum(num / 10, sum + (num % 10));
}