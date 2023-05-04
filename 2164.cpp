#include <iostream>
#include <deque>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	deque<int> card;
	int num;

	cin >> num;

	for (int i = 1; i <= num; i++)
		card.emplace_front(i);

	while (num != 1)
	{
		card.pop_back();
		card.emplace_front(card.back());
		card.pop_back();
		--num;
	}

	cout << card.front();
	return 0;
}