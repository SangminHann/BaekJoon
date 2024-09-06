#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int heigh, climb, slip, rst = 1;

	scanf("%d %d %d", &climb, &slip, &heigh);
	heigh -= climb;
	rst += heigh / (climb -= slip);
	if (heigh % climb)
		rst++;
	printf("%d\n", rst);
}