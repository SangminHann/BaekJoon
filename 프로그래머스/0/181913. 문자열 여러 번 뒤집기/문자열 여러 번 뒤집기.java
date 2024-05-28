class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] answer = my_string.toCharArray();
        char tmp;

        for (int[] q : queries) {
            while (q[0] < q[1]) {
                tmp = answer[q[0]];
                answer[q[0]++] = answer[q[1]];
                answer[q[1]--] = tmp;
            }
        }
        
        return new String(answer);
    }
}