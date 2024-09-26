#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

char* cntChr(char* itr, char croatia[][4]);

int main()
{
	char croatia[8][4] = { "c=","c-","dz=","d-","lj","nj","s=","z=" };
	char str[101], * itr = str, * p; int cnt = 0;
	scanf("%s", str);
	while (*itr)
	{
		itr = cntChr(itr, croatia);
		cnt++;
	}
	printf("%d\n", cnt);
}

char* cntChr(char* itr, char croatia[][4])
{
	char* tmp; int check = 0;
	for (int i = 0; i < 8; i++)
	{
		tmp = strstr(itr, croatia[i]);
		if (tmp == itr)
		{
			itr += strlen(croatia[i]);
			check = 1;
			break;
		}
	}
	if (!check)
		itr++;
	return (itr);
}