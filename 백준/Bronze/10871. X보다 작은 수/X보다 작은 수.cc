#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int n, x, input;

	scanf("%d %d", &n, &x);
	while (n--)
	{
		scanf("%d", &input);
		if (input < x)
			printf("%d ", input);
	}

	return (0);
}