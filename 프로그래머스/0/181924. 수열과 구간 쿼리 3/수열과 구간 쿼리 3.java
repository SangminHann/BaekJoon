class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int tmp;
        
        for (int[] q : queries) {
            tmp = arr[q[0]];
            arr[q[0]] = arr[q[1]];
            arr[q[1]] = tmp;
        }
        
        return arr;
    }
}