#include <iostream>

using namespace std;
int is_peace_move(int *cor, int hor, int ver);
void move_king(int *Kcor, int *Scor, int hor, int ver);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	string king, stone, move;
	int Kcor[2], Scor[2], t, hor, ver;

	cin >> king >> stone >> t;
	Kcor[0] = king[0] - 'A';
	Kcor[1] = king[1] - '1';
	Scor[0] = stone[0] - 'A';
	Scor[1] = stone[1] - '1';

	while (t--)
	{
		hor = ver = 0;
		cin >> move;

		if (move[0] == 'L')
			hor = -1;
		else if (move[0] == 'R')
			hor = 1;
		else if (move[0] == 'B')
			ver = -1;
		else if (move[0] == 'T')
			ver = 1;

		if (move[1] == 'B')
			ver = -1;
		else if (move[1] == 'T')
			ver = 1;

		move_king(Kcor, Scor, hor, ver);
	}

	cout << (char)(Kcor[0] + 'A') << Kcor[1] + 1 << '\n';
	cout << (char)(Scor[0] + 'A') << Scor[1] + 1 << '\n';
	return 0;
}

void move_king(int *Kcor, int *Scor, int hor, int ver)
{
	if (Kcor[0] + hor == Scor[0] && Kcor[1] + ver == Scor[1])
	{
		if (!is_peace_move(Scor, hor, ver))
			return;
		Kcor[1] += ver;
		Kcor[0] += hor;
		Scor[1] += ver;
		Scor[0] += hor;
		return;
	}
	if (!is_peace_move(Kcor, hor, ver))
		return;
	Kcor[1] += ver;
	Kcor[0] += hor;
}

int is_peace_move(int *cor, int hor, int ver)
{
	int _hor = cor[0] + hor, _ver = cor[1] + ver;

	if (_hor < 0)
		return 0;
	if (_hor > 7)
		return 0;
	if (_ver < 0)
		return 0;
	if (_ver > 7)
		return 0;

	return 1;
}
