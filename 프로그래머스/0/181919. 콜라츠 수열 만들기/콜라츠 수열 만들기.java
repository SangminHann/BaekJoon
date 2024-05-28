import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        while (n != 1) {
            arr.add(n);
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
        }
        arr.add(1);
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}