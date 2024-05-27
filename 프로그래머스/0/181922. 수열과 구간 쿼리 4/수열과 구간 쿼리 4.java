class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for (int[] q : queries) {
            for (int j = q[0]; j <= q[1]; j++) {
                if (j % q[2] == 0) {
                    ++arr[j];
                }
            }
        }
        
        return arr;
    }
}