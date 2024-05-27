class Solution {
    public String solution(int[] numLog) {
        
        String answer = "";
        
        for (int i = 1; i < numLog.length; i++) {
            answer += switch (numLog[i] - numLog[i - 1]) {
                    case 1 -> "w";
                    case -1 -> "s";
                    case 10 -> "d";
                    default -> "a";
            };
        }
        
        return answer;
    }
}