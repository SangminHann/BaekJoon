#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int mod[10], num, cnt, rst = 0;
	
	for (int i = 0; i < 10; i++)
		mod[i] = 42;

	for (int i = 0; i < 10; i++)
	{
		scanf("%d", &num);
		for (cnt = 0; cnt < 10; cnt++)
			if (mod[cnt] == num % 42)
				break;
		if (cnt == 10)
		{
			mod[i] = num % 42;
			rst++;
		}
	}
	printf("%d", rst);

	return (0);
}