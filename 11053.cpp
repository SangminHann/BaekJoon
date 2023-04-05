#include <iostream>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t, tmp, max = 0;
	int **seq;
	cin >> t;

	seq = new int *[t];
	for (int i = 0; i < t; i++)
	{
		seq[i] = new int[2];
		seq[i][1] = 1;
	}

	for (int i = 0; i < t; i++)
		cin >> seq[i][0];

	for (int i = 0; i < t; i++)
	{
		for (int j = i + 1; j < t; j++)
		{
			if (seq[j][0] > seq[i][0] && seq[j][1] <= seq[i][1])
				seq[j][1] = seq[i][1] + 1;
		}
	}

	for (int i = 0; i < t; i++)
		if (max < seq[i][1])
			max = seq[i][1];

	cout << max;
	return 0;
}