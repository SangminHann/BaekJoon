#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void ft_print(int num, char* str)
{
	for (int i = 0; str[i]; i++)
		for (int j = 0; j < num; j++)
			printf("%c", str[i]);
	printf("\n");
}

int main()
{
	char str[21]; int num;

	scanf("%d", &num);
	for (int i = num; i > 0; i--)
	{
		scanf("%d %s", &num, str);
		ft_print(num, str);
	}

	return (0);
}