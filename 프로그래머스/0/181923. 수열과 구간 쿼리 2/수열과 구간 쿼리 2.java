import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int min;
        
        for (int i = 0; i < queries.length; i++) {
            min =  1000001;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (queries[i][2] < arr[j]) {
                    min = (min > arr[j]) ? arr[j] : min;
                }
                
            }
            answer[i] = (min != 1000001) ? min : -1;
        }
        
        return answer;
    }
}