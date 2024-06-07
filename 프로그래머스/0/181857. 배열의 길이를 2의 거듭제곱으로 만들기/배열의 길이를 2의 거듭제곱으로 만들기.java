class Solution {
    public int[] solution(int[] arr) {
        int i = 1;
        
        while (i < arr.length) {
            i *= 2;
        }
        int[] answer = new int[i];
        for (i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        
        while (i < answer.length) {
            answer[i++] = 0;
        }
        
        return answer;
    }
}