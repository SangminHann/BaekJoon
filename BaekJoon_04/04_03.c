#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void cnt_arr(int* arr, int rst)
{
	if (rst == 0)
		return;

	arr[rst % 10]++;
	cnt_arr(arr, rst / 10);
}

int main(void)
{
	int arr[10] = { 0 }, rst, a, b, c;

	scanf("%d", &a);
	scanf("%d", &b);
	scanf("%d", &c);
	rst = a * b * c;
	cnt_arr(arr, rst);
	for (int i = 0; i < 10; i++)
		printf("%d\n", arr[i]);

	return (0);
}