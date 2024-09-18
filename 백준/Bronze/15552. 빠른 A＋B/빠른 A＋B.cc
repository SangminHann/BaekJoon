#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int i, a, b;

	scanf("%d", &i);
	for (int j = 0; j < i; j++)
	{
		scanf("%d %d", &a, &b);
		printf("%d\n", a + b);
	}

	return (0);
}