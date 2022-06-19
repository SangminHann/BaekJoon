#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int a, b, c;

	scanf("%d", &a);
	scanf("%d", &b);

	c = b;
	for (int i = 0; i < 3; i++)
	{
		printf("%d\n", a * (b % 10));
		b /= 10;
	}
	printf("%d", a * c);

	return (0);
}