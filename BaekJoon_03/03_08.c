#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int i, a, b;

	scanf("%d", &i);
	for (int j = 1; j <= i; j++)
	{
		scanf("%d %d", &a, &b);
		printf("Case #%d: %d + %d = %d\n", j, a, b, a + b);
	}

	return (0);
}