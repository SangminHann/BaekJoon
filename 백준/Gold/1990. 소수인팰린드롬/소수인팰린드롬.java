import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> answer = new LinkedList<>();
        int a, b;

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        boolean[] sieve = new boolean[b + 1];
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (sieve[i]) {
                continue;
            }

            for (int j = i + i; j <= b; j += i) {
                sieve[j] = true;
            }
        }

        int s, e;
        boolean flag;
        for (int i = a; i <= b; i++) {
            if (sieve[i]) {
                continue;
            }
            
            flag = true;
            String cand = Integer.toString(i);
            s = 0;
            e = cand.length() - 1;

            while (s < e) {
                if (cand.charAt(s++) != cand.charAt(e--)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer.add(cand);
            }
        }

        for (String tmp : answer) {
            System.out.println(tmp);
        }

        System.out.println(-1);
    }
}