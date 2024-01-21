#include <iostream>

using namespace std;

class Cabbage {
private:
	int field[50][50];
	int X, Y, num, cnt;

public:
	void setField()
	{
		int x, y;
		for (int i = 0; i < Y; i++)
			for (int j = 0; j < X; j++)
				field[i][j] = 0;

		while (num--)
		{
			cin >> x >> y;
			field[y][x] = -1;
		}
	}

	void setCor() {
		cin >> X >> Y >> num;
	}

	void mark(int x, int y)
	{
		if (x < 0 || y < 0 || x == X || y == Y)
			return;
		if (field[y][x] != -1)
			return;
		field[y][x] = cnt;
		mark(x + 1, y);
		mark(x - 1, y);
		mark(x, y + 1);
		mark(x, y - 1);
	}

	void cntWarm()
	{
		setField();
		cnt = 0;
		for (int i = 0; i < Y; i++)
			for (int j = 0; j < X; j++)
			{
				if (field[i][j] == -1)
				{
					++cnt;
					mark(j, i);
				}
			}
	}

	void getCnt()
	{
		cout << cnt << "\n";
	}
};

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	Cabbage a;
	int t;

	cin >> t;
	while (t--)
	{
		a.setCor();
		a.cntWarm();
		a.getCnt();
	}

	return 0;
}