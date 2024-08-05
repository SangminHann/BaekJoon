#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int is_max(int* dice)
{
	int max = 0;
	for (int i = 0; i < 3; i++)
	{
		if (max < *dice)
			max = *dice;
		dice++;
	}
	return (max);
}

int is_overlap(int* dice)
{
	int cnt = 0;
	for (int i = 0; i < 3; i++)
		for (int j = i + 1; j < 3; j++)
			if (dice[i] == dice[j])
				cnt++;

	return (cnt);
}

int main(void)
{
	int dice[3];

	scanf("%d %d %d", &dice[0], &dice[1], &dice[2]);
	if (is_overlap(dice) == 3)
		printf("%d", 10000 + 1000 * dice[0]);
	else if (is_overlap(dice) == 1)
	{
		int i = -1;
		int j;
		while (++i < 3)
		{
			j = i;
			while (++j < 3)
				if (dice[i] == dice[j])
					break;
			if (dice[i] == dice[j])
				break;
		}
		printf("%d", 1000 + 100 * dice[i]);
	}
	else
		printf("%d", 100 * is_max(dice));

	return (0);
}