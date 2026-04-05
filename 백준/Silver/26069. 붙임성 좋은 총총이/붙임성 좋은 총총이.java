import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Set<String> s = new HashSet<>();
        s.add("ChongChong");

        while (t-- > 0) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            String a = str.nextToken(), b = str.nextToken();

            if (s.contains(a) || s.contains(b)) {
                s.add(a);
                s.add(b);
            }
        }

        System.out.println(s.size());
    }
}