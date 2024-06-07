class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        int idx = 0;
        boolean flag;
        
        for (int a : arr) {
            flag = true;
            for (int i = 0; i < idx; i++) {
                if (answer[i] == a) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer[idx++] = a;
            }
            if (idx == answer.length) {
                break;
            }
        }
        
        while (idx < answer.length) {
            answer[idx++] = -1;
        }
        
        return answer;
    }
}