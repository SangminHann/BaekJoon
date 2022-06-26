#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int isCorrect(int num)
{
	int diff, tmp;
	
	if (num < 100)
		return (1);

	diff = (num % 10) - ((num / 10) % 10);
	tmp = num / 10;
	if (diff == (tmp % 10) - ((tmp / 10) % 10))
		return (1);

	return (0);
}

int main()
{
	int num, cnt = 0;

	scanf("%d", &num);
	for (int i = 1; i <= num && i < 1000; i++)
	{
		if (isCorrect(i))
			cnt++;
	}
	printf("%d\n", cnt);

	return (0);
}