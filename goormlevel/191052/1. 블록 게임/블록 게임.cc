#include <iostream>
#include <set>
#include <vector>
#include <stack>
#include <tuple>

using namespace std;


//u d r l
int main() {
	int dx[4] = {0, 0, 1, -1}, dy[4] = {1, -1, 0, 0}, n, x = 0, y = 0, rst = 0;
	string str;
	
	cin >> n;
	cin >> str;
	vector<int> score(n);
	for (auto &a : score)
		cin >> a;
	
	set<pair<int, int>> visited;
	stack<tuple<int, int, int>> s;
	s.emplace(y, x, 1);
	visited.insert({y, x});
	
	for (int i = 0; i < n; i++)
	{
		switch (str[i]) {
			case 'U':
				x += dx[0];
				y += dy[0];
				break;
			case 'D':
				x += dx[1];
				y += dy[1];
				break;
			case 'R':
				x += dx[2];
				y += dy[2];
				break;
			default :
				x += dx[3];
				y += dy[3];
				break;
	}
		
		auto tmp = visited.insert({y, x});
		if (!tmp.second)
		{
			while (!s.empty())
			{
				auto [curY, curX, curScore] = s.top();
				
				if (curY == y && curX == x)
				{
					s.pop();
					s.emplace(y, x, score[i]);
					break;
				}
				
				else
				{
					visited.erase({curY, curX});
					s.pop();
				}
			}
		}
		else
			s.emplace(y, x, score[i]);
	}
	
	while(!s.empty())
	{
		auto [curY, curX, curScore] = s.top();
		rst += curScore;
		s.pop();
	}
	
	 cout << rst;
	
	return 0;
}