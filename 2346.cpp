#include <iostream>
#include <deque>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

    int n, num;
    pair<int, int> tmp;

    cin >> n;
    deque<pair<int, int>> balloon(n);

    for (int i = 0; i < n; i++)
    {
        cin >> balloon[i].first;
        balloon[i].second = i + 1;
    }


    while (n--)
    {
        cout << balloon[0].second << " ";

        num = balloon[0].first;
        balloon.pop_front();

        if (n > 1)
        {
            if (num < 0)
            {
                while (num++)
                {
                    balloon.emplace_front(balloon.back());
                    balloon.pop_back();
                }
            }

            else
            {
                while (--num)
                {
                    balloon.emplace_back(balloon.front());
                    balloon.pop_front();
                }
            }
        }
    }
    
    return 0;
}