import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        int s = 1, e = 1;
        
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                s = 0;
                e = i;
                break;
            } else if (str_list[i].equals("r")) {
                s = i + 1;
                e = str_list.length;
                break;
            }
        }
        
        if (s == e) {
            return new String[0];
        }
        
        return Arrays.copyOfRange(str_list, s, e);
    }
}