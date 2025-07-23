import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), cnt = 0;
        Set<String> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            s.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            if (s.contains(br.readLine())) {
                ++cnt;
            }
        }

        System.out.println(cnt);
    }
}