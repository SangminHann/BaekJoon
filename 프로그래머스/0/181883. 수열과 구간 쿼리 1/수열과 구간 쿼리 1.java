class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        for (int[] q : queries) {
            while (q[0] <= q[1]) {
                ++arr[q[0]++];
            }
        }
        
        return arr;
    }
}