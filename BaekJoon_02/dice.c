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
	printf("%d", ((dice[0] == dice[1]) && (dice[1] == dice[2]) ? 100 + dice[0] * 10 \
		: (dice[0] == dice[1]) || (dice[0] == dice[2]) ? 10 + dice[0] \
		: (dice[1] == dice[2]) ? 10 + dice[1] \
		: (dice[0] > dice[1]) && (dice[0] > dice[2]) ? dice[0] \
		: (dice[1] > dice[0]) && (dice[1] > dice[2]) ? dice[1] \
		: dice[2]) * 100);

	return (0);
}