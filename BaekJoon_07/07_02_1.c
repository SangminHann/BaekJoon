#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int i = 1, n;
	for (scanf("%d", &n); n > 1;)
		n -= i++ * 6;
	printf("%d\n", i);
}