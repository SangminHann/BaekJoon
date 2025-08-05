import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] num, cal = new int[4];

    public static void recursive(int depth, int rst) {
        if (n == depth) {
            min = Math.min(min, rst);
            max = Math.max(max, rst);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if(cal[i] != 0) {
                --cal[i];
                if (i == 0) {
                    recursive(depth + 1, rst + num[depth]);
                } else if (i == 1) {
                    recursive(depth + 1, rst - num[depth]);
                } else if (i == 2) {
                    recursive(depth + 1, rst * num[depth]);
                } else {
                    recursive(depth + 1, rst / num[depth]);
                }
                ++cal[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        recursive(1, num[0]);

        System.out.println(max + "\n" + min);
    }
}