import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), cnt = 0;
        Set<String> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                cnt += s.size();
                s.clear();
            } else {
                s.add(str);
            }
        }

        System.out.println(cnt + s.size());
    }
}