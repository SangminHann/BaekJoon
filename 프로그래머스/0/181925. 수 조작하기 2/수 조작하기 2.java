class Solution {
    public String solution(int[] numLog) {
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 1; i < numLog.length; i++) {
            answer.append(
                switch (numLog[i] - numLog[i - 1]) {
                    case 1 -> "w";
                    case -1 -> "s";
                    case 10 -> "d";
                    default -> "a";
            });
        }
        
        return answer.toString();
    }
}