class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n + 1][m + 1];
        
        for (int[] tmp : puddles) {
            arr[tmp[1] - 1][tmp[0]] = -1;
        }
        
        arr[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == -1) {
                    continue;
                }
                
                if (arr[i][j - 1] != -1) {
                    arr[i][j] = (arr[i][j] + arr[i][j - 1]) % 1000000007;
                }
                
                if (arr[i + 1][j] != -1) {
                    arr[i + 1][j] = (arr[i + 1][j] + arr[i][j]) % 1000000007;
                }
            }
        }
        
        return arr[n][m];
    }
}