#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int hour, min, need_time;

	scanf("%d %d", &hour, &min);
	scanf("%d", &need_time);
	printf("%d %d", (hour + (need_time + min) / 60) % 24, (min + need_time) % 60);

	return (0);
}