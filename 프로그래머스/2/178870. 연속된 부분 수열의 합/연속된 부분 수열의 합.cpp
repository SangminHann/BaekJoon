#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer(2, 1000001);
    int start = 0, end = 0, len = 1000001, seqLen = sequence.size(), sum;
    
    sum = sequence[0];
    while (start <= end)
    {
        if (sum < k)
        {
            if (++end == seqLen)
                break;
            sum += sequence[end];
        }
        if (sum > k)
            sum -= sequence[start++];
        if (sum == k)
        {
            if (len > (end - start))
            {
                answer[0] = start;
                answer[1] = end;
                len = end - start;
            }
            sum -= sequence[start++];
        }           
    }
    return answer;
}