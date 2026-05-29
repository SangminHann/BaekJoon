import java.util.*;

class Solution {
    
    char[][] arr;
    int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    
    void recursive(int y, int x) {
        arr[y][x] = 0;
        
        for (int i = 0; i < 4; i++) {
            int curY = y + dy[i];
            if (curY < 0 || curY == arr.length) {
                continue;
            }
            
            int curX = x + dx[i];
            if (curX < 0 || curX == arr[0].length || arr[curY][curX] == 0 | arr[curY][curX] != 1) {
                continue;
            }
            
            recursive(curY, curX);
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        int answer = storage.length * storage[0].length();
        
        arr = new char[storage.length][];
        for (int i = 0; i < storage.length; i++) {
            arr[i] = storage[i].toCharArray();
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < requests.length; i++) {
            if (requests[i].length() == 2) {
                for (int j = 0; j < arr.length; j++) {
                    for (int k = 0; k < arr[0].length; k++) {
                        if (requests[i].charAt(0) == arr[j][k]) {
                            arr[j][k] = 1;
                            --answer;
                            for (int l = 0; l < 4; l++) {
                                int curY = dy[l] + j, curX = dx[l] + k;
                                
                                if (curY < 0 || curX < 0 || curY == arr.length || curX == arr[0].length || arr[curY][curX] == 0){
                                    recursive(j, k);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            
            else {
                for (int j = 0; j < arr.length; j++) {
                    for (int k = 0; k < arr[0].length; k++) {
                        if (requests[i].charAt(0) == arr[j][k]) {
                            for (int l = 0; l < 4; l++) {
                                int curY = dy[l] + j, curX = dx[l] + k;
                                
                                if (curY < 0 || curX < 0 || curY == arr.length || curX == arr[0].length || arr[curY][curX] == 0){
                                    --answer;
                                    dq.addLast(new int[]{j, k});
                                    break;
                                }
                            }
                        }
                    }
                }
                while (!dq.isEmpty()) {
                    int[] cur = dq.pollFirst();
                    recursive(cur[0], cur[1]);
                }
            }
        }
        
        return answer;
    }
}