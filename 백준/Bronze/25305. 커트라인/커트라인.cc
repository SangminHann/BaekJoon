#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	vector<int> score; int num, cutLine, tmp;

	cin >> num>>cutLine;
	for (int i = 0; i < num; i++)
	{
		cin >> tmp;
		score.push_back(tmp);
	}
	sort(score.begin(), score.end());
	for (int i = 0; i < cutLine - 1; i++)
		score.pop_back();
	cout << score[score.size() - 1];

	return 0;
}