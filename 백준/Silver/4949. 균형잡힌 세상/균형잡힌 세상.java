import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while (!(str = br.readLine()).equals(".")){
            Deque<Character> d = new ArrayDeque<>();
            int i = 0;

            for (; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    d.addLast(str.charAt(i));
                } else if (str.charAt(i) == '[') {
                    d.addLast(str.charAt(i));
                } else if (str.charAt(i) == ']') {
                    if (d.peekLast() == null || d.peekLast() != '[') {
                        break;
                    } else {
                        d.removeLast();
                    }
                } else if (str.charAt(i) == ')') {
                    if (d.peekLast() == null || d.peekLast() != '(') {
                        break;
                    } else {
                        d.removeLast();
                    }
                } 
            }

            if (d.isEmpty() && i == str.length()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}