    import java.util.*;

    class Solution {
        public int[] solution(int[] arr) {
            int[] answer = new int[Arrays.stream(arr).sum()];
            int idx = 0;

            for (int a : arr) {
                for (int i = 0; i < a; i++) {
                    answer[idx++] = a;
                }
            }

            return answer;
        }
    }