import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length && d[i] <= budget; i++) {
            ++answer;
            budget -= d[i];
        }
        
        return answer;
    }
}