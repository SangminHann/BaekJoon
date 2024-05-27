import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        while (l <= r) {
            int tmp = l;
            boolean flag = true;
            
            while (tmp != 0) {
                if (!(tmp % 10 == 5 || tmp % 10 == 0)) {
                    flag = false;
                    break;
                }
                tmp /= 10;
            }
            
            if (flag) {
                arr.add(l);
            }
            l++;
        }
        
        if (arr.isEmpty()) {
            arr.add(-1);
        }
        
        return arr.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}