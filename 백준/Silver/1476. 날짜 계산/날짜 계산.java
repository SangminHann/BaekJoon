import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = 1, s = 1, m = 1, cnt = 1, a, b, c;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        while (!(a == e && b == s && c == m)) {
            e = ++e == 16 ? 1 : e;
            s = ++s == 29 ? 1 : s;
            m = ++m == 20 ? 1 : m;
            ++cnt;
        }

        System.out.println(cnt);
    }
}