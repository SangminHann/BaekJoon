#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int max = 20000001, num, tmp; int* arr = new int[max] {0};

	cin >> num;
	for (int i = 0; i < num; i++)
	{
		cin >> tmp;
		arr[tmp + 10000000]++;
	}
	cin >> num;
	for (int i = 0; i < num; i++)
	{
		cin >> tmp;
		cout << arr[tmp + 10000000] << " ";
	}

	return 0;
}