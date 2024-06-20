class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        int d = 0, x = 0, y = 0, i = 1;
        
        while (i <= n * n) {
            answer[y][x] = i++;
            int nx = x + dx[d], ny = y + dy[d];
            
            if (nx < 0 || nx == n || ny < 0 || ny == n || answer[ny][nx] != 0) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            
            y = ny;
            x = nx;
        }
        
        
        return answer;
    }
}