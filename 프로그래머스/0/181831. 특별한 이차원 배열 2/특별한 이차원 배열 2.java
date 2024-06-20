class Solution {
    public int solution(int[][] arr) {
        boolean flag = true;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                flag = arr[i][j] == arr[j][i] ? true : false;
                if (!flag) {
                    return 0;
                }
            }
        }
        return 1;
    }
}