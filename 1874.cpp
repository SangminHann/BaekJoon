#include <iostream>
#include <queue>
#include <stack>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	queue<string> op;
	stack<int> sequence;
	int t, num, i = 0;

	sequence.push(0);
	cin >> t;
	while (t--)
	{
		cin >> num;
		if (sequence.top() < num)
		{
			while (i < num)
			{
				sequence.push(++i);
				op.push("+");
			}
		}

		if (sequence.top() == num)
		{
			op.push("-");
			sequence.pop();
		}
		else
		{
			cout << "NO";
			return 0;
		}
	}

	while (!op.empty())
	{
		cout << op.front() << '\n';
		op.pop();
	}
	return 0;
}