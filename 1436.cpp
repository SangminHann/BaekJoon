#include <iostream>

using namespace std;
int countSix(int num, int cnt);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int input, rst, cnt = 0;

	cin >> input;
	for (rst = 666; cnt < input; rst++)
		if (countSix(rst, 0) == 3)
			cnt++;
	cout << rst - 1;

	return 0;
}

int countSix(int num, int cnt)
{
	if (!num || cnt == 3)
		return cnt;
	if (num % 10 == 6)
		return countSix(num / 10, cnt + 1);
	return countSix(num / 10, 0);
}