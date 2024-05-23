import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] answer = a.toCharArray();
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Character.isUpperCase(answer[i])
                ? Character.toLowerCase(answer[i])
                : Character.toUpperCase(answer[i]);
        }
        
        System.out.print(String.valueOf(answer));
    }
}