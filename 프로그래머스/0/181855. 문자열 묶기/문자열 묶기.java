import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> m = new HashMap<>();
        int answer = 0;
        
        for (String str : strArr) {
            m.put(str.length(), m.getOrDefault(str.length(),0) + 1);
        } 
        for(Map.Entry<Integer, Integer> e : m.entrySet()) {
            answer = (answer < e.getValue()) ? e.getValue() : answer;
        }
        
        return answer;
    }
}