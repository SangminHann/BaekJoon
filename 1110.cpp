#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <ctype.h>

int main()
{
	char str[1000001]; int cnt;

	scanf("%[^\n]s", str);
	int i;
	cnt = i = 0;
	while (str[i])
	{
		if (isspace(str[i]))
			i++;
		if (!isspace(str[i]) && str[i])
		{
			cnt++;
			while (!isspace(str[i]) && str[i])
				i++;
		}
	}


	printf("%d", cnt);

	return (0);
}