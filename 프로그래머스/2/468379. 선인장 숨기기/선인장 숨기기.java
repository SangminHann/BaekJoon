import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] arr = new int[m][n];
        int[] ans = new int[2];
        int max = -1;
        for (int i = 0; i < m; i++) {
            Arrays.fill(arr[i], 500001);
        }
        
        for (int i = 0; i < drops.length; i++) {
            arr[drops[i][0]][drops[i][1]] = i;
        }
        
        int[][] slide = new int[m][n - w + 1];
        
        for (int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                while (!dq.isEmpty() && arr[i][dq.peekLast()] >= arr[i][j]) {
                    dq.pollLast();
                }
                
                dq.addLast(j);
            
                if (j - w >= dq.peekFirst()) {
                    dq.pollFirst();
                }
                
                if (j >= w - 1) {
                    slide[i][j - w + 1] = arr[i][dq.peekFirst()];
                }
            }
        }
        
        for (int i = 0; i < slide[0].length; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                while (!dq.isEmpty() && slide[dq.peekLast()][i] >= slide[j][i]) {
                    dq.pollLast();
                }
                
                dq.addLast(j);
            
                if (j - h >= dq.peekFirst()) {
                    dq.pollFirst();
                }
                
                if (j >= h - 1) {
                    slide[j - h + 1][i] = slide[dq.peekFirst()][i];
                }
            }
        }

        for (int i = 0; i <= m - h; i++) {
            for (int j = 0; j <= n - w; j++) {
                if (max < slide[i][j]) {
                    max = slide[i][j];
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        
        return ans;
    }
}