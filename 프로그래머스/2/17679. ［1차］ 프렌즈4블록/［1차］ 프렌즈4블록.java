import java.io.*;
import java.util.*;

class Solution {
    char[][] arr;
    Deque<int[]> dq = new ArrayDeque<>();
    int y, x;
    int[] dy = {0, 0, 1, 1}, dx = {0, 1, 0, 1};
    
    void addDelete(int a, int b) {
        if (arr[a][b] == 0) {
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (arr[a + dy[i]][b + dx[i]] != arr[a + dy[i + 1]][b + dx[i + 1]]) {
                return;
            }
        }
        dq.add(new int[]{a, b});
    }
    
    int deleteBlock(int a, int b) {
        int ans = 0;
        
        for (int i = 0; i < 4; i++) {
            if (arr[a + dy[i]][b + dx[i]] != 0) {
                ans++;
                arr[a + dy[i]][b + dx[i]] = 0;
            }
        }
        
        return ans;
    }

    boolean moveBlock(int a, int b) {
        int i = a;
        while (i >= 0) {
            if (arr[i][b] != 0) {
                break;
            }
            i--;
        }
        
        if (i == -1) {
            return false;
        }
        
        arr[a][b] = arr[i][b];
        arr[i][b] = 0;
        return true;
    }
    
    
    public int solution(int m, int n, String[] board) {
        y = board.length;
        x = board[0].length();
        arr = new char[y][];
        
        for (int i = 0; i < y; i++) {
            arr[i] = board[i].toCharArray();
        }
        
        int ans = 0;
        
        while (true) {
            for (int i = 0; i < y - 1; i++) {
                for (int j = 0; j < x - 1; j++) {
                    addDelete(i, j);
                }
            }
            
            if (dq.isEmpty()) {
                break;
            }
            
            while (!dq.isEmpty()) {
                int[] cur = dq.pop();
                ans += deleteBlock(cur[0], cur[1]);
            }
            
            for (int i = 0; i < x; i++) {
                for (int j = y - 1; j > 0; j--) {
                    if (arr[j][i] != 0) {
                        continue;
                    }
                    if (!moveBlock(j, i)) {
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}