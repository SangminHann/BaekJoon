#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int num, size, * arr, cnt; double rst;

	scanf("%d", &num);
	while (num--)
	{
		scanf("%d", &size);
		arr = (int*)malloc(sizeof(int) * size); rst = cnt = 0;
		for (int i = 0; i < size; i++)
		{
			scanf("%d", &arr[i]);
			rst += arr[i];
		}
		rst /= (double)size;
		for (int i = 0; i < size; i++)
			if ((double)arr[i] > rst)
				cnt++;
		printf("%.3lf%%\n", cnt / (double)size * 100);
		free(arr);
	}
}