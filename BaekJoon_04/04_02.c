#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	int arr[9], index, max;

	for (int i = 0; i < 9; i++)
		scanf("%d", &arr[i]);
	max = arr[0];
	index = 1;

	for (int i = 1; i < 9; i++)
	{
		if (max < arr[i])
		{
			max = arr[i];
			index = i + 1;
		}
	}
	printf("%d\n%d", max, index);

	return (0);
}