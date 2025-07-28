import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String str = br.readLine();
            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                cnt += (str.charAt(i) == '(') ? 1 : -1;
                if (cnt == -1) {
                    break;
                }
            }

            if (cnt == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}