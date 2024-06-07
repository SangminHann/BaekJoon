import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> answer = new ArrayDeque<>();
        
        for (int a : arr) {
            if (answer.isEmpty() || answer.peekLast() != a) {
                answer.addLast(a);
            } else {
                answer.removeLast();
            }
        }
        
        if (answer.isEmpty()) {
            return new int[] {-1};
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}