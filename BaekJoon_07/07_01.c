#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int A, B, C;

	scanf("%d %d %d", &A, &B, &C);
	C > B ?  printf("%d\n", (A / (C - B)) + 1) \
		: printf("%d\n", -1);

	return (0);
}