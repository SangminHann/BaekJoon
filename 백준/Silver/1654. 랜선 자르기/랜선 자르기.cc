#include <iostream>
#include <vector>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int k;
	long long start, end, mid, n, sum;


	start = end = 1;
	cin >> k >> n;

	vector<long long> line(k);
	for (int i = 0; i < k; i++)
	{
		cin >> line[i];
		if (line[i] > end)
			end = line[i];
	}

	while (start <= end)
	{
		mid = (start + end) / 2;
		sum = 0;
		for (int i = 0; i < k; i++)
			sum += (line[i] / mid);

		if (sum >= n)
			start = mid + 1;
		else
			end = mid - 1;
	}

	cout << start - 1;
	return 0;
}