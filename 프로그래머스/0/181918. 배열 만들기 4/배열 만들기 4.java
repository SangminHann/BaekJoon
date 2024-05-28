import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        
        for (int a : arr) {
            while (!stk.isEmpty() && stk.peek() >= a) {
                stk.pop();
            }
            stk.push(a);
        }
        
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }
}