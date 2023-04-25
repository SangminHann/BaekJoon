#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main()
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	stack<string> parenthesis;
	string sentence;
	int len, flag = 1;

	getline(cin, sentence);
	len = sentence.length();

	while (len != 1)
	{
		for (int i = 0; i < len; i++)
		{
			if (sentence[i] == '(')
				parenthesis.push("(");

			else if (sentence[i] == '[')
				parenthesis.push("[");

			else if (sentence[i] == ')')
			{
				if (parenthesis.empty() || parenthesis.top() != "(")
				{
					flag = 0;
					break;
				}
				parenthesis.pop();
			}

			else if (sentence[i] == ']')
			{
				if (parenthesis.empty() || parenthesis.top() != "[")
				{
					flag = 0;
					break;
				}
				parenthesis.pop();
			}
		}

		if (flag && parenthesis.empty())
			cout << "yes\n";
		else
			cout << "no\n";

		while (!parenthesis.empty())
			parenthesis.pop();

		getline(cin, sentence);
		len = sentence.length();
		flag = 1;
	}

	return 0;
}