#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void ft_clean(char* OX)
{
	for (int i = 0; i < 81; i++)
		OX[i] = 0;
}

int main(void)
{
	char OX[81] = { 0 }; int seq = 0, rst = 0, num;

	scanf("%d", &num);
	while (num--)
	{
		scanf("%s", OX);
		for (int i = 0; i < 81 && OX[i]; i++)
		{
			if (OX[i] == 'O')
				rst += 1 + seq++;
			else
				seq = 0;
		}
		printf("%d\n", rst);
		seq = rst = 0, ft_clean(OX);
	}
	
}