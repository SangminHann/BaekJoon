#include <vector>
#include <stack>
#include <algorithm>
#include <tuple>
#include <string>

using namespace std;

bool comp(vector<string>& a, vector<string>& b)
{
    return a[1] < b[1];
}

int intHour(string& hour)
{
    return (stoi(hour.substr(0,2)) * 60 + stoi(hour.substr(3)));
}

vector<string> solution(vector<vector<string>> plans) 
{
    vector<string> answer, curSub;
    stack<tuple<string, int>> s;
    int sub, duration;

    sort(plans.begin(), plans.end(), comp);
    
    for (int i = 0; i < (int)(plans.size() - 1); i++)
    {
        sub = intHour(plans[i + 1][1]) - intHour(plans[i][1]);
        duration = stoi(plans[i][2]);
        
        if (sub >= duration)
        {
            sub -= duration;
            answer.emplace_back(plans[i][0]);
        }
        else
        {
            s.emplace(plans[i][0], duration - sub);
            continue;
        }
        
        while (!s.empty())
        {
            auto [name, tmpDuration] = s.top();
            s.pop();
            if (sub >= tmpDuration)
            {
                sub -= tmpDuration;
                answer.emplace_back(name);
            }
            else
            {
                s.emplace(name, tmpDuration - sub);
                break;
            }
        }
    }
    
    answer.emplace_back(plans.back()[0]);
    while (!s.empty())
    {
        auto [name, tmpDuration] = s.top();
        s.pop();
        answer.emplace_back(name);
    }
    
    return answer;
}
