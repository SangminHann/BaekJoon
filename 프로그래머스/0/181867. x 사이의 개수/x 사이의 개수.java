import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] arr = myString.split("x", -1);
        int[] answer = new int[arr.length];
        int i = 0;
        
        for (String a : arr) {
            answer[i++] = a.length();
        }
        
        return answer;
    }
}