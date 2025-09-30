import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int cnt = 0, serverCnt = 0;
        List<Integer> arr = new LinkedList<>();
        
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j) + k - 1 < i) {
                    arr.remove(j);
                    --j;
                } 
            }
            
            int tmp =  players[i] / m;
            
            for (int j = arr.size(); j < tmp; j++) {
                arr.add(i);
                ++cnt;
            }
        }
        
        return cnt;
    }
}