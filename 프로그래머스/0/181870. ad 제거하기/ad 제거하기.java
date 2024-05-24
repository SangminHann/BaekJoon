import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> arr = new ArrayList<>();
        
        for (String str : strArr) {
            if (!str.contains("ad")) {
                arr.add(str);
            }
        }
        
        return arr.toArray(new String[0]);
    }
}