#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	char* itr, word[101] = { 0 }; int place[26];

	scanf("%s", word);
	for (int i = 0; i < 26; i++)
		place[i] = -1;
	for (int i = 0; word[i]; i++)
	{
		if (place[word[i] - 'a'] == -1)
			place[word[i] - 'a'] = i;
	}
	for (int i = 0; i < 26; i++)
		printf("%d ", place[i]);
}