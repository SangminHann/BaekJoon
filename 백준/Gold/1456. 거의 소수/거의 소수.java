import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a, b, c, answer = 0;
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = (long)Math.sqrt(b);

        boolean[] sieve = new boolean[(int)(c + 1)];
        for (int i = 2; i <= Math.sqrt(c); i++) {
            if (sieve[i]) {
                continue;
            }

            for (int j = i + i; j <= c; j += i) {
                sieve[j] = true;
            }
        }

        for (int i = 2; i <= c; i++) {
            if (sieve[i]) {
                continue;
            }

            long tmp, exp = 2;

            do {
                tmp = (long)Math.pow(i, exp++);
            } while (tmp < a);

            while (tmp <= b) {
                ++answer;
                tmp = (long)Math.pow(i, exp++);
            }
        }

        System.out.println(answer);
    }
}