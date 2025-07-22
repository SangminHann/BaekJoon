#include <iostream>


using namespace std; //floor = 19, room 21 일때 출력까지 620초 걸림
int cntBag(int kg, int cnt);

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	int kg;

	cin >> kg;
	cout << cntBag(kg, 0);

	return (0);
}

int cntBag(int kg, int cnt)
{
	if (kg < 0)
		return (-1);
	if (kg == 0)
		return (cnt);
	if (kg % 5 == 0)
		return (cnt + (kg / 5));
	return cntBag(kg - 3, cnt + 1);
}