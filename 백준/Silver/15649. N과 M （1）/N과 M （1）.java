import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static int n, depth;
    static int[] arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void recursive(int i) {
        if (i == depth) {
            for (int j = 0; j < depth; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int j = 1; j <= n; j++) {
            if (!used[j]) {
                used[j] = true;
                arr[i] = j;
                recursive(i + 1);
                used[j] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        depth = Integer.parseInt(st.nextToken());
        arr = new int[depth];
        used = new boolean[n + 1];

        recursive(0);
        System.out.println(sb);
    }
}