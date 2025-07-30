#include <iostream>

using namespace std;

void makeCantor(int start, int len, string& cantor)
{
	if (len <= 1)
		return;

	int div = len / 3;
	for (int i = 0; i < div; i++)
		cantor[start + div + i] = ' ';
	makeCantor(start, div, cantor);
	makeCantor(start + div * 2, div, cantor);
}

string makeString(string cantor)
{
	string rst = cantor;
	rst.append(cantor);
	rst.append(cantor);
	return rst;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string cantor;
	int n;
	while (cin >> n)
	{
		cantor = "-";

		for (int i = 1; i <= n; i++)
			cantor = makeString(cantor);
		makeCantor(0, cantor.length(), cantor);
		cout << cantor + '\n';
	}
	return 0;
}
