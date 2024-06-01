import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        char[] answer = new char[my_string.length() - indices.length];
        int idx = 0, aIdx = 0;
        Arrays.sort(indices);
        
        for (int i = 0; i < my_string.length(); i++) {
            if (indices.length > idx && indices[idx] == i) {
                ++idx;
            } else {
                answer[aIdx++] = my_string.charAt(i);
            }
        }
        
        return new String(answer);
    }
}