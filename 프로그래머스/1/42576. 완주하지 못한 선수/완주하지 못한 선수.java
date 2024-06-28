import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> m = new HashMap<>();
        
        for (String par : participant) {
            m.put(par, m.getOrDefault(par, 0) + 1);
        }
        
        for (String com : completion) {
            m.put(com, m.get(com) - 1);
        }
        
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            if (e.getValue() > 0) {
                return e.getKey();
            }
        }
        return "";
    }
}