#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

bool compare(string a, string b);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int input;
	string *word;

	cin >> input;
	word = new string[input];
	for (int i = 0; i < input; i++)
		cin >> word[i];
	sort(word, word + input, compare);
	for (int i = 0; i < input - 1; i++)
		if (word[i] != word[i + 1])
			cout << word[i] << '\n';
	cout << word[input - 1];

	return 0;
}

bool compare(string a, string b)
{
	if (a.length() == b.length())
		return 0 > strcmp(a.c_str(), b.c_str());
	return a.length() < b.length();
}
