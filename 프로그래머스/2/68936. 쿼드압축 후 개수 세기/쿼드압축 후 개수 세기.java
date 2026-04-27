class Solution {
    int[] cnt = {0 ,0};
    int[][] _arr;
    
    void recursive(int y, int x, int size) {
        
        if (size == 1) {
            cnt[_arr[y][x]]++;
            return;
        }
        
        int a = _arr[y][x];
        boolean flag = true;
        
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (a != _arr[i][j]) {
                    flag = false;
                    break;
                }
            }
            
            if (!flag) {
                break;
            }
        }
        
        if (flag) {
            cnt[a]++;
            return;
        }
        size /= 2;
        recursive(y, x, size);
        recursive(y + size, x, size);
        recursive(y, x + size, size);
        recursive(y + size, x + size, size);
    }
    
    public int[] solution(int[][] arr) {
        
        _arr = arr;
        recursive(0, 0, arr.length);
        return cnt;
    }
}