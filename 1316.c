#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void initArr(char *str);

int main()
{
	int n, group, rst = 0;
	char str[101], check[26];

	scanf("%d", &n);
	while (n--)
	{
		initArr(check);
		group = 1;
		scanf("%s", str);
		for (int i = 0; str[i]; i++)
		{
			if (!check[str[i] - 'a'])
				check[str[i] - 'a'] = 1;
			else if (i - 1 >= 0 && str[i - 1] != str[i])
			{
				group = 0;
				break;
			}
		}
		if (group)
			rst++;
	}
	printf("%d\n", rst);

	return (0);
}

void initArr(char *str)
{
	for (int i = 0; i < 26; i++)
		str[i] = 0;
}