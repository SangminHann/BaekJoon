import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        
        m.put(a, m.getOrDefault(a, 0) + 1);
        m.put(b, m.getOrDefault(b, 0) + 1);
        m.put(c, m.getOrDefault(c, 0) + 1);
        m.put(d, m.getOrDefault(d, 0) + 1);
        
        if (m.size() == 4) {
            return m.firstKey();
        } else if (m.size() == 1) {
            return m.firstKey() * 1111;
        } else if (m.containsValue(3)) {
            int answer = 0;
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                if (entry.getValue() == 3) {
                    answer += entry.getKey() * 10;
                } else {
                    answer += entry.getKey();
                }
            }
            return answer * answer;
        } else if (m.size() == 2) {
            List<Integer> keys = new ArrayList<>(m.keySet());
            return (keys.get(0) + keys.get(1)) * Math.abs(keys.get(0) - keys.get(1));
        } else {
            int answer = 1;
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                if (value == 1) {
                    answer *= key;
                }
            }
            return answer;
        }
    }
}