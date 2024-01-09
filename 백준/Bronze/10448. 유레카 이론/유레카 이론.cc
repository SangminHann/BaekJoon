#include <iostream>
#define CANDIDATE_SIZE 3
#define TRINUM_SIZE 46

using namespace std;

int candidate[CANDIDATE_SIZE], triNum[TRINUM_SIZE] = {1, 3, 6, 10, 15, 21, 28, 36, 45, \
55, 66, 78, 91, 105, 120, 136, 153, 171, 190, 210, 231, \
253, 276, 300, 325, 351, 378, 406, 435, 465, 496, 528, 561, \
595, 630, 666, 703, 741, 780, 820, 861, 903, 946, 990, 2000};
int flag, num;

void combinationWithRepetition(int depth, int start)
{
    if (depth == CANDIDATE_SIZE)
    {
        if (num == triNum[candidate[0]] + triNum[candidate[1]] + triNum[candidate[2]])
            flag = 1;
        
        return ;
    }

    for (int i = start; triNum[i] < num; i++)
    {
        candidate[depth] = i;
        combinationWithRepetition(depth + 1, i);
        if (flag)
            return;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int T;

    cin >> T;
    while (T--)
    {
        cin >> num;

        flag = 0;
        combinationWithRepetition(0, 0);
        cout << flag << "\n";
    }

    return 0;
}