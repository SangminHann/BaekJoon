#include <iostream>
#include <deque>
#include <algorithm>

using namespace std;

void init_deque(deque<string> &num, string input)
{
	string tmp;
	num.clear();
	tmp.clear();

	for (int i = 1; input[i] != ']'; i++)
	{
		if (input[i] == ',')
		{
			num.emplace_back(tmp);
			tmp.clear();
		}
		else
			tmp.push_back(input[i]);
	}
	if (!tmp.empty())
		num.emplace_back(tmp);
}

void print_deque(deque<string> &num)
{
	int size = num.size() - 1;

	cout << "[";
	for (int i = 0; i < size; i++)
		cout << num[i] << ",";
	if (size >= 0)
		cout << num[size];
	cout << "]\n";
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	deque<string> num;
	string input, instruction;
	int t, size, instructLen, errFlag, revFlag;

	cin >> t;
	while (t--)
	{
		cin >> instruction >> size >> input;

		errFlag = 0;
		revFlag = 0;
		init_deque(num, input);
		instructLen = instruction.length();

		for (int i = 0; i < instructLen; i++)
		{
			if (instruction[i] == 'R')
				revFlag = !revFlag;
			else if (size--)
			{
				if (revFlag)
					num.pop_back();
				else
					num.pop_front();
			}
			else
			{
				errFlag = 1;
				break;
			}
		}

		if (!errFlag && revFlag)
			reverse(num.begin(), num.end());

		if (errFlag)
			cout << "error\n";
		else
			print_deque(num);
	}
	return 0;
}