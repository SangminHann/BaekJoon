#include <stdio.h>

int isSelfNum(int num)
{
	for (int i = 1; i <= num; i++)
		if (i + digitSum(i) == num)
			return (0);

	return (1);
}

int digitSum(int num)
{
	int rst = 0;
	while (num)
	{
		rst += num % 10;
		num /= 10;
	}
	
	return (rst);
}

int main()
{
	for (int num = 1; num <= 10000; num++)
		if (isSelfNum(num))
			printf("%d\n", num);

	return (0);
}