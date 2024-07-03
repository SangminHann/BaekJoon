import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        long b, c, answer = 0;
        b = Long.parseLong(st.nextToken());
        c = (long)Math.sqrt(b);
        BigInteger B = BigInteger.valueOf(b);

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

            BigInteger tmp = BigInteger.valueOf(i), mul = BigInteger.valueOf(i);

            do {
                tmp = tmp.multiply(mul);
            } while (tmp.compareTo(a) == -1);

            while (tmp.compareTo(B) != 1) {
                ++answer;
                tmp = tmp.multiply(mul);
            }
        }

        System.out.println(answer);
    }
}