class Solution {
    int max;
    int cnt = 0;
    int[] board;
    
    boolean isAttacked(int n) {
        for (int i = 0; i < n; i++) {
            if (board[i] == board[n]) {
                return true;
            }
            
            if (Math.abs(board[i] - board[n]) == n - i) {
                return true;
            }
        }
        
        return false;
    }
    
    void nQueen(int n) {
        if (n == max) {
            ++cnt;
            return ;
        }
        
        for (int i = 0; i < max; i++) {
            board[n] = i;
            if (isAttacked(n)) {
                continue;
            }
            
            nQueen(n + 1);
        }
    }
    
    public int solution(int n) {
        max = n;
        board = new int[n];
        
        nQueen(0);
        return cnt;
    }
}