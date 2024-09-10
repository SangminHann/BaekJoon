#include <iostream>
#include <algorithm>

using namespace std;
int is_prime(int input);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int num, cnt = 0, input;
	
	cin >> num;
	while (num--)
	{
		cin >> input;
		if (is_prime(input))
			cnt++;
	}
	cout << cnt;

	return (0);
}

int is_prime(int input)
{
	int cnt = 0;
	for (int i = 2; i * i <= input; i++)
		if (!(input % i))
			cnt++;
	if (cnt || input == 1)
		return (0);
	return (1);
}