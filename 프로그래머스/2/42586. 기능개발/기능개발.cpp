#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) 
{
    vector<int> answer;
    int i = 0, j = 0, day, k = 1, flag;
    
    while (i < (int)progresses.size())
    {
        day = (100 - progresses[i]) / speeds[i] + (((100 - progresses[i]) % speeds[i]) ? 1 : 0 );
        k = 0;
        flag = 1;
        j = i;
        
        while (j < (int)progresses.size())
        {
            progresses[j] += (day * speeds[j]);
            if (progresses[j] >= 100 && flag)
                k++;
            else
                flag = 0;
            j++;
        }
        answer.emplace_back(k);
        i += k;
    }
    
    return answer;
}