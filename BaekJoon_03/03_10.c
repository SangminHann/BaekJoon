#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int i;

	scanf("%d", &i);
	for (int j = 1; j <= i; j++)
	{
		for (int l = i - j; l > 0; l--)
			printf(" ");
		for (int k = 0; k < j; k++)
			printf("*");
		printf("\n");
	}

	return (0);
}