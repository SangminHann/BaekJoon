import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static long d, p, ans = -1;


    static void recursive(long start, long num, long depth) {
        if (("" + num).length() > d) {
            return ;
        } 

        if (depth == p) {
            ans = Long.max(num, ans);
            return;
        }

        for (long i = start; i < 10; i++) {
            recursive(i, num * i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        d = Long.parseLong(s[0]);
        p = Long.parseLong(s[1]);
        recursive(2, 1, 0);

        System.out.println(ans);
    }
}