class Solution {
    int _target;
    int[] numbs;
    int cnt = 0;
    
    void dfs(int idx, int val) {
        if (idx == numbs.length) {
            if (_target == val) {
                ++cnt;
            }
            
            return;
        }
        
        dfs(idx + 1, val + numbs[idx]);
        dfs(idx + 1, val - numbs[idx]);
    }
    
    public int solution(int[] numbers, int target) {
        _target = target;
        numbs = numbers;
        
        dfs(0, 0);
        
        return cnt;
    }
}