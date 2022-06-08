#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int size, * arr, min, max;

	scanf("%d", &size);
	arr = (int*)malloc(sizeof(int) * size);

	for (int i = 0; i < size; i++)
		scanf("%d", &arr[i]);
	min = max = arr[0];

	for (int i = 1; i < size; i++)
	{
		if (min > arr[i])
			min = arr[i];
		else if (max < arr[i])
			max = arr[i];
	}
	printf("%d %d", min, max);
	free(arr);

	return (0);
}