#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int i, sum = 0;

	scanf("%d", &i);
	for (int j = 1; j <= i; j++)
		sum += j;
	printf("%d", sum);

	return (0);
}