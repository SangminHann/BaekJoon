#include <iostream>
#include <algorithm>
#define DWARF_ORIGIN 7
#define NUM 9


using namespace std;

int dwarf[9], candidate[7];

void combination(int depth, int start)
{
    if (depth == DWARF_ORIGIN)
    {
        int sum = 0;
        for (auto &a : candidate)
            sum += a;
        
        if (sum == 100)
        {
            sort(candidate, candidate + DWARF_ORIGIN);
            for (auto &a : candidate)
                cout << a << "\n";
            exit(0);
        }
        
        return ;
    }

    for (int i = start; i < NUM; i++)
    {
        candidate[depth] = dwarf[i];
        combination(depth + 1, i + 1);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    for (auto &a : dwarf)
        cin >> a;
    
    combination(0, 0);

    return 0;
}