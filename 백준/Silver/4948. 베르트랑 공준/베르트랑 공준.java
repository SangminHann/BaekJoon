import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = 123456 * 2;
        
        boolean[] isPrime = new boolean[m + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int i = 2; i <= m; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= m; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int cnt = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (isPrime[i]) {
                    ++cnt;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
