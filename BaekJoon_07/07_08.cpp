#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	string num[2], rst = ""; int i, j, lng = 1, shrt = 0, tmp, plus = 0;
	cin >> num[0] >> num[1];
	if (num[0].length() >= num[1].length())
		lng = 0, shrt = 1;
	i = num[lng].length() - 1, j = num[shrt].length() - 1;
	for (; j >= 0; i--, j--)
	{
		tmp = num[lng][i] + num[shrt][j] + plus;
		if (tmp <= 105)
			tmp -= 48, plus = 0;
		else
			tmp -= 58, plus = 1;
		rst.push_back(tmp);
	}
	if (i >= 0)
	{
		for (; i >= 0; i--)
		{
			tmp = num[lng][i] + plus;
			if (tmp == 58)
				tmp = 48, plus = 1;
			else
				plus = 0;
			rst.push_back(tmp);
		}
	}
	if (plus)
		rst.push_back(plus + 48);
	reverse(rst.begin(), rst.end());
	cout << rst << '\n';

	return (0);
}
