#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int ft_max(int *arr, int size)
{
	int max;

	max = arr[0];

	for (int i = 1; i < size; i++)
	{
		if (max < arr[i])
			max = arr[i];
	}

	return (max);
}

int main(void)
{
	int *arr, size, max;
	double rst = 0;

	scanf("%d", &size);
	arr = (int *)malloc(sizeof(int) * size);
	for (int i = 0; i < size; i++)
		scanf("%d", &arr[i]);
	max = ft_max(arr, size);
	for (int i = 0; i < size; i++)
		rst += (arr[i] / (double)max * 100);
	printf("%lf", rst / size);

	return (0);
}