class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        boolean mode = false;
        
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                mode = !mode;
            } else if (!mode) {
                if (i % 2 == 0) {
                    answer.append(code.charAt(i));
                }
            } else {
                if (i % 2 == 1) {
                    answer.append(code.charAt(i));
                }
            }
        }
        
        if (answer.length() == 0)
            return "EMPTY";

        return answer.toString();
    }
}