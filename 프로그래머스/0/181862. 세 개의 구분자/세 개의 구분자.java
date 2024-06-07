import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = Arrays.stream(myStr.split("[abc]"))
                                .filter(str -> !str.isEmpty())
                                .toArray(String[]::new);
        
        if (answer.length == 0) {
            String[] empty = new String[1];
            empty[0] = "EMPTY";
            return empty; 
        }
        
        return answer;
    }
}