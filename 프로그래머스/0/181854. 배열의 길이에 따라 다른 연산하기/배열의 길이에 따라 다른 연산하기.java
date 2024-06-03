class Solution {
    public int[] solution(int[] arr, int n) {
        int i = (arr.length % 2 == 0) ? 1 : 0;
        
        while (i < arr.length) {
            arr[i] += n;
            i += 2;
        }
        
        return arr;
    }
}