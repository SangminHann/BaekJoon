import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        List<Integer>[] arr = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        
        dq.addLast(new int[]{1, 1});
        visited[1] = true;
        while (!dq.isEmpty()) {
            int[] v = dq.pollFirst();
            dist[v[0]] = v[1];
            
            for (int next : arr[v[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dq.addLast(new int[]{next, v[1] + 1});
                }
            }
        }
        
        int max = 0, cnt = 0;
        for (int i : dist) {
            if (i == max) {
                cnt++;
            } else if (i > max) {
                max = i;
                cnt = 1;
            }
        }
        
        return cnt;
    }
}