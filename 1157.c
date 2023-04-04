#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void isMax(int *alpha)
{
	int max = alpha[0], cnt = 0, index;

	for (int i = 1; i < 26; i++)
	{
		if (max == alpha[i])
			cnt++;
		else if (max < alpha[i])
			max = alpha[i], cnt = 0, index = i;
	}

	cnt == 0 ? printf("%c", index + 'A') : printf("?");
}

int main()
{
	int alpha[26] = {0};
	char str[1000001];

	scanf("%s", str);
	for (int i = 0; str[i]; i++)
	{
		if (str[i] >= 'a' && str[i] <= 'z')
			alpha[str[i] - 'a']++;
		else
			alpha[str[i] - 'A']++;
	}
	isMax(alpha);

	return (0);
}