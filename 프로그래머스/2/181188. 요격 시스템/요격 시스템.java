import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int answer = 1, curEnd = targets[0][1];
        
        for (int[] target : targets) {
            if (curEnd <= target[0]) {
                answer++;
                curEnd = target[1];
            }
        }
        
        return answer;
    }
}