import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> s = new HashSet<>();
        String str = br.readLine();

        int len = 1;
        while (len <= str.length()) {
            for (int i = 0; i <= str.length() - len; i++) {
                s.add(str.substring(i, i + len));
            }
            ++len;
        }

        System.out.println(s.size());
    }
}