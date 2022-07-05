#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int reverseNum(int num);

int main()
{
	int num1, num2;

	scanf("%d %d", &num1, &num2);
	num1 = reverseNum(num1);
	num2 = reverseNum(num2);
	num1 > num2 ? printf("%d", num1) : printf("%d", num2);

	return (0);
}

int reverseNum(int num)
{
	int rst = 0;

	for (int i = 0; i < 3; i++)
	{
		rst *= 10;
		rst += (num % 10);
		num /= 10;
	} 

	return (rst);
}