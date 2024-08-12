#include <iostream>
#include <deque>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	deque<int> sequence;
	int size, t, num, idx, cnt = 0;

	cin >> size >> t;
	for (int i = 1; i <= size; ++i)
		sequence.emplace_back(i);

	while (t--)
	{
		cin >> num;
		idx = 0;

		while (sequence[idx] != num)
			++idx;
		
		if (idx * 2 <= size)
		{
			cnt += idx;
			while (idx)
			{
				sequence.emplace_back(sequence.front());
				sequence.pop_front();
				--idx;
			}
			sequence.pop_front();
		}

		else
		{
			cnt += (idx = size - idx);
			while (idx)
			{
				sequence.emplace_front(sequence.back());
				sequence.pop_back();
				--idx;
			}
			sequence.pop_front();
		}
		--size;
	}

	cout << cnt;
	return 0;
}