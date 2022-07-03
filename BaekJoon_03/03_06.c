#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int i;

	scanf("%d", &i);
	for (; 1 <= i; i--)
		printf("%d\n", i);

	return (0);
}