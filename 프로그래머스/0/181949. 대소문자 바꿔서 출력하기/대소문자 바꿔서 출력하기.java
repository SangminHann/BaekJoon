import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder(a);
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z')
                sb.setCharAt(i, (char)(sb.charAt(i) + 32));
            else
                sb.setCharAt(i, (char)(sb.charAt(i) - 32));
        }
        
        System.out.print(sb.toString());
    }
}