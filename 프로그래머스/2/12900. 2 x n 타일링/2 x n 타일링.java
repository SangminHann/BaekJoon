class Solution {
    public int solution(int n) {
        int[][] tile = new int[n + 2][2]; // 0 가로 1 세로
        
        tile[0][1] = tile[1][1] = 1; // 세로
        tile[1][0] = 1; // 가로 끝지점
        
        for (int i = 2; i < n; i++) {
            tile[i][0] = (tile[i - 2][1] + tile[i - 2][0]) % 1000000007;
            tile[i][1] = (tile[i - 1][1] + tile[i - 1][0]) % 1000000007;
        }
        
        return (tile[n - 1][0] + tile[n - 1][1]) % 1000000007;
    }
}