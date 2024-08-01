#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int aToi(char c);

int main()
{
	char str[16]; int rst = 0;
	
	scanf("%s", str);
	for (int i = 0; str[i]; i++)
		rst += aToi(str[i]);
	printf("%d\n", rst);

	return (0);
}

int aToi(char c)
{
	if ('A' <= c && c <= 'C')
		return (3);
	if ('D' <= c && c <= 'F')
		return (4);
	if ('G' <= c && c <= 'I')
		return (5);
	if ('J' <= c && c <= 'L')
		return (6);
	if ('M' <= c && c <= 'O')
		return (7);
	if ('P' <= c && c <= 'S')
		return (8);
	if ('T' <= c && c <= 'V')
		return (9);
	if ('W' <= c && c <= 'Z')
		return (10);
}