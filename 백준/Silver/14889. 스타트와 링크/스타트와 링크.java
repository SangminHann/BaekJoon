import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    static boolean[] isPicked = new boolean[20];
    static int[] max = {0, 0, 3, 10, 35, 126, 462, 1716, 6435, 24310, 92378}, link = new int[20], start = new int[20];
    static int[][] status = new int[20][];
    static int n, min = Integer.MAX_VALUE, cnt = 0;;

    public static void recursive(int depth, int s, int idx) {
        
        if (depth * 2 == n) {
            for (int i = 0, j = 0; i < n; i++) {
                if (!isPicked[i]) {
                    link[j++] = i;
                }
            }

            int l = 0;
            for (int i = 0; i < depth; i++) {
                for (int j = 0; j < depth; j++) {
                    l += status[link[i]][link[j]];
                }
            }

            min = Math.min(min, Math.abs(s - l));

            if (++cnt == max[depth]) {
                System.out.println(min);
                System.exit(0);
            }

            return;
        }

        for (int i = idx; i < n; i++) {
            isPicked[i] = true;
            start[depth] = i;
            int tmp = 0;

            for (int j = 0; j < depth; j++) {
                tmp += status[i][start[j]];
                tmp += status[start[j]][i];
            }

            recursive(depth + 1, s + tmp, i + 1);
            isPicked[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        isPicked = new boolean[n];
        link = new int[n / 2];
        start = new int[n /2];
        for (int i = 0; i < n; i++) {
            status[i] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        recursive(0, 0, 0);
    }
}