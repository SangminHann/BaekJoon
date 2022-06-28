#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int n, numStr, rst = 0;

	scanf("%d", &n);
	scanf("%d", &numStr);
	for (int i = 0; i < n; i++)
	{
		rst += numStr % 10;
		numStr /= 10;
	}
	printf("%d\n", rst);

	return (0);
}