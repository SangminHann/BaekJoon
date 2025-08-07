#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> getPsum(vector<vector<int>>& arr) {

	vector<vector<int>> rst(arr.size() + 1, vector<int>(arr[0].size() + 1, 0));

	for (int i = 1; i < rst.size(); i++)
		for (int j = 1; j < rst[0].size(); j++)
			rst[i][j] = rst[i - 1][j] + rst[i][j - 1] - rst[i - 1][j - 1] + arr[i - 1][j - 1];

	return rst;
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n, m, x1, x2, y1, y2;
	cin >> n >> m;

	vector<vector<int>> square(n, vector<int>(n, 0));

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> square[i][j];

	vector<vector<int>> psum = getPsum(square);

	while (m--)
	{
		cin >> y1 >> x1 >> y2 >> x2;
		int rst = psum[y2][x2];

		rst -= psum[y1 - 1][x2];
		rst -= psum[y2][x1 - 1];
		rst += psum[y1 - 1][x1 - 1];

		cout << rst << "\n";
	}
}