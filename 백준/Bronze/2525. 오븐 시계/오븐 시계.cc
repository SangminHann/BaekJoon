#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int hour, min, need_time;

	scanf("%d %d", &hour, &min);
	scanf("%d", &need_time);
	hour += ((min += (need_time % 60)) / 60) + need_time / 60;
	min %= 60;
	if (hour > 23)
		hour -= 24;
	printf("%d %d", hour, min);

	return (0);
}