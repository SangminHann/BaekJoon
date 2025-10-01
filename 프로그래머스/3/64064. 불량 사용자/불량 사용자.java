import java.util.*;

class Solution {
    
    boolean[] used;
    int userLen = 0, banLen = 0;
    String[] user, banned;
    List<boolean[]> cand = new ArrayList<>();
    
    void recursive(int depth) {
        if (depth == banLen) {
            boolean flag = true;
            
            for (boolean[] tmp : cand) {
                if (Arrays.equals(tmp, used)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                cand.add(used.clone());
            }
            
            return;
        }
        
        for (int i = 0; i < userLen; i++) {
            if (!used[i] && user[i].length() == banned[depth].length()) {
                boolean flag = true;
                for (int j = 0; j < user[i].length(); j++) {
                    if (banned[depth].charAt(j) == '*') {
                        continue;
                    } else if (banned[depth].charAt(j) != user[i].charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    used[i] = true;
                    recursive(depth + 1);
                    used[i] = false;
                }
            }
        }
    
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
        used = new boolean[user_id.length];
        
        user = user_id;
        banned = banned_id;
        userLen = user_id.length;
        banLen = banned_id.length;
        recursive(0);

        return cand.size();
    }
}