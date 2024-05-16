#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) 
{
    vector<int> answer(photo.size(), 0);
    map<string, int> nameWithYearn;
    
    for (int i = 0; i < (int)(name.size()); i++)
        nameWithYearn[name[i]] = yearning[i];
    
    for (int i = 0; i < (int)(answer.size()); i++)
        for (auto p : photo[i])
            answer[i] += nameWithYearn[p];
    
    return answer;
}