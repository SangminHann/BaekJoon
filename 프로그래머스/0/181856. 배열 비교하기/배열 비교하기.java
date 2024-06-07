import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return (arr1.length < arr2.length ? -1 : 1);
        } 
        
        int value1 = Arrays.stream(arr1).sum(), value2 = Arrays.stream(arr2).sum();
        if (value1 != value2) {
            return (value1 < value2 ? -1 : 1);
        }
        
        return 0;
    }
}