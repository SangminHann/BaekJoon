#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds)
{
    vector<int> answer(1, 0);
    int day, pastDay = (99 - progresses[0]) / speeds[0] + 1;;
    
    for (int i = 0; i < (int)progresses.size(); ++i)
    {
        day = (99 - progresses[i]) / speeds[i] + 1;

        if (pastDay < day)
        {
            answer.emplace_back(1);
            pastDay = day;
        }
            
        else
            ++answer.back();
    }

    return answer;
}