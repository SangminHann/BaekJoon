#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    answer.emplace_back(arr[0]);
    for (auto &a : arr)
        if (answer.back() != a)
            answer.emplace_back(a);

    return answer;
}