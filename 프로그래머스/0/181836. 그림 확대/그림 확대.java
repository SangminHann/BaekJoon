class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        
        for (int i = 0, l = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : picture[i].toCharArray()) {
                for (int j = 0; j < k; j++) {
                    sb.append(c);
                }
            }
            for (int m = 0; m < k; m++) {
                answer[l++] = sb.toString();
            }
        }
        return answer;
    }
}