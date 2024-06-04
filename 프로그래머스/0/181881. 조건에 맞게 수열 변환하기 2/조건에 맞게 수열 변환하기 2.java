class Solution {
    public int solution(int[] arr) {
        int answer = 0, flag = 0;
        
        while (true) {
            if (flag == 1) {
                return answer - 1;
            }
            flag = 1;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                    flag = 0;
                } else if (arr[i] < 50 && arr[i]  % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                    flag = 0;
                }
            }
            answer++;
        }
    }
}