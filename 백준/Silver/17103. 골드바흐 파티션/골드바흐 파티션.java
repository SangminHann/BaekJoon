import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isNprime = new boolean[1000001];
        for (int i = 2; i * i <= 1000000; i++) {
            if (!isNprime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isNprime[j] = true;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int cnt = 0, n = Integer.parseInt(br.readLine());
            for (int i = 2; i <= n / 2; i++) {
                if (!isNprime[i] && !isNprime[n - i]) {
                    ++cnt;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}