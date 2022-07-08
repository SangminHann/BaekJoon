#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int a, b, c, n;
	n = a = b = c = 0;
	for (; a = getchar() - 10; c = b, b = a - 90)
		n += a > 52 ? a - 96 || b - 8 && b - 10 : -!(b - 22 | c);
	printf("%d", n);
}