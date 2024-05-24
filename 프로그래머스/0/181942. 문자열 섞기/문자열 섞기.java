class Solution {
    public String solution(String str1, String str2) {
        char[] answer = new char[str1.length() + str2.length()];
        
        for (int i = 0; i < str1.length(); i++) {
            answer[i * 2] = str1.charAt(i);
            answer[i * 2 + 1] = str2.charAt(i);
        }
        
        return String.valueOf(answer);
    }
}