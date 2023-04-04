#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main()
{
	char str[1000001], *ptr;
	int cnt = 0;

	scanf("%[^\n]s", str);
	ptr = strtok(str, " ");
	while (ptr)
	{
		ptr = strtok(NULL, " ");
		cnt++;
	}
	printf("%d\n", cnt);
}