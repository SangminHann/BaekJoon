import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] cnt = new int[3], idx = new int[3], div = {5, 8, 10};
        ArrayList<Integer> arr = new ArrayList<>();
        int[][] supoza = {
                    {1, 2, 3, 4, 5, 0, 0, 0, 0, 0}, 
                    {2, 1, 2, 3, 2, 4, 2, 5, 0, 0}, 
                    {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                cnt[j] += (answers[i] == supoza[j][idx[j]] ? 1 : 0);
                idx[j] = (idx[j] + 1) % div[j];
            }
        }
        
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = max < cnt[i] ? cnt[i] : max;
        }
        
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max) {
                arr.add(i + 1);
            }
        }
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}