#include <iostream>

using namespace std;
int main() 
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int* arr = new int[10001]{ 0 }; int num, input;

	cin >> num;
	for (int i = 0; i < num; i++)
	{
		cin >> input;
		arr[input]++;
	}
	for (int i = 0, cnt = 0; i < 10001 && cnt < num; i++)
		if (arr[i])
			for (; arr[i]; arr[i]--, cnt++)
				cout << i << '\n';
	return 0;
}