class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
            
        for (int i = 0; i < my_string.length(); i++) {
            ++answer[(int)(my_string.charAt(i) >= 'a' 
                           ? my_string.charAt(i) - 'a' + 26
                           : my_string.charAt(i) - 'A')];
        }
        
        return answer;
    }
}