import java.util.*;
class Solution {
    public int solution(int a, int b) {
        String str1 = Integer.toString(a) + Integer.toString(b);
        String str2 = Integer.toString(b) + Integer.toString(a);
        
        return str1.compareTo(str2) > 0 ?
            Integer.parseInt(str1) :
            Integer.parseInt(str2);
    }
}