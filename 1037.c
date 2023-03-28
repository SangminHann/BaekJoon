#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int num, * arr;

	cin >> num;
	arr = new int[num];

	for (int a = 0; a < num; a++)
		cin >> arr[a];

	if (num == 1)
		cout << arr[0] * arr[0];
	else
	{
		sort(arr, arr + num);
		cout << arr[0] * arr[num - 1];
	}

	return 0;
}