import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int cnt = 0;

    public static int recursive(String s, int l, int r) {
        ++cnt;
        if (l >= r) {
            return 1;
        } if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        return recursive(s, l + 1, r - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String str;

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            str = br.readLine();
            sb.append(recursive(str, 0, str.length() - 1)).append(" ").append(cnt).append('\n');
            cnt = 0;
        } 
        System.out.println(sb);
    }
}