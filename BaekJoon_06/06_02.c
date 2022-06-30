#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int n, rst = 0; char numStr[101];

	scanf("%d", &n);
	scanf("%s", numStr);
	for (int i = 0; i < n; i++)
		rst += numStr[i] -'0';
	printf("%d\n", rst);

	return (0);
}