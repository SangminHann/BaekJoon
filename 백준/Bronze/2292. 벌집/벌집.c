#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int cntRoom(int cnt, int room);

int main()
{
	int room, cnt = 1;

	scanf("%d", &room);
	if (room != 1)
	{
		if (!((room - 1) % 6))
			room = (--room / 6);
		else
			room = (room = (--room / 6)) + 1;
		cnt = cntRoom(cnt, room);
	}
	printf("%d\n", cnt);
	
	return (0);
}

int cntRoom(int cnt, int room)
{
	if (!room)
		return (cnt);
	if (room > cnt)
		room -= cnt;
	else
		room = 0;
	cntRoom(++cnt, room);
}