#include <stdio.h>

long long sum(int* a, int n)
{
	long long rst = 0;
	for (int i = 0; i < n; i++)
		rst += a[i];
	
	return (rst);
}