#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> initVector(int n)
{
	vector<int> rst(n);

	for (int i = 0; i < n; i++)
		cin >> rst[i];

	return rst;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	vector<int> nArray, mArray;
	int n, m;

	cin >> n;
	nArray = initVector(n);
	sort(nArray.begin(), nArray.end());
	cin >> m;
	mArray = initVector(m);

	for (int i = 0; i < m; i++)
	{
		if (binary_search(nArray.begin(), nArray.end(), mArray[i]))
			cout << "1\n" ;
		else
			cout << "0\n";
	}

	return 0;
}