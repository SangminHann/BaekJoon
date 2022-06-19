#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int fst, before, after = -1 , cnt = 0;
	
	scanf("%d", &fst);
	before = fst;
	while (fst != after)
	{
		after = (((before / 10) + (before % 10)) % 10) + (before % 10) * 10;
		before = after; cnt++;
	}
	printf("%d", cnt);
	return (0);
}