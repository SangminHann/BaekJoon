import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] arr = new HashSet[9];
        
        for (int i = 1; i < 9; i++) {
            arr[i] = new HashSet<>();
        }
        
        arr[1].add(N);
        
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int l : arr[j]) {
                    for (int r : arr[i - j]) {
                        arr[i].add(l - r);
                        arr[i].add(l + r);
                        arr[i].add(l * r);
                        if (r != 0) {
                            arr[i].add(l / r);
                        }
                    }
                }
            }
            
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp = tmp * 10 + 1;
            }
            
            arr[i].add(tmp * N);
        }
        
        for (int i = 1; i < 9; i++) {
            if (arr[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}