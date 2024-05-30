class Solution {
    public String solution(String my_string, int s, int e) {
        char[] answer = my_string.toCharArray();
        char c;
        
        while (s < e) {
            c = answer[s];
            answer[s++] = answer[e];
            answer[e--] = c;
        }
        
        return new String(answer);
    }
}