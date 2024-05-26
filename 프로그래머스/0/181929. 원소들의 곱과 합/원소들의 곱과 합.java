class Solution {
    public int solution(int[] num_list) {
        int answer1 = 1, answer2 = 0;
        
        for (int a : num_list) {
            answer1 *= a;
            answer2 += a;
        }

        return answer1 < (answer2 * answer2) ? 1 : 0;
    }
}