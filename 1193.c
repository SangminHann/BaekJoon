#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int cross = 1, input, denom, numer; // 분모+분자 == 대각선에 있는 분수 수 - 1

	scanf("%d", &input);
	while (input > cross)
		input -= cross++;
	if (cross % 2 == 1)
	{
		numer = cross - input + 1;
		denom = input;
	}
	else
	{
		denom = cross - input + 1;
		numer = input;
	}
	printf("%d/%d\n", numer, denom);

	return (0);
}