#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int i;

	scanf("%d", &i);
	for (int j = 1; j <= i; j++)
		printf("%d\n", j);

	return (0);
}