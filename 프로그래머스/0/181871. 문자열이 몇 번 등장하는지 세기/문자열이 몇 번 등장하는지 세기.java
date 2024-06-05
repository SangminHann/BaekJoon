class Solution {
    public int solution(String myString, String pat) {
        int answer = 0, idx = 0;
        
        idx = myString.indexOf(pat, idx);
        
        while (idx != -1) {
            answer++;
            idx = myString.indexOf(pat, idx + 1);
        }
        
        return answer;
    }
}