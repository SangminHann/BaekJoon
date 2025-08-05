import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static int n, depth;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void recursive(int i, int d) {
        if (d == depth) {
            for (int j = 0; j < depth; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int j = i; j <= n; j++) {
            arr[d] = j;
            recursive(j, d + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        depth = Integer.parseInt(st.nextToken());
        arr = new int[depth];

        recursive(1, 0);
        System.out.println(sb);
    }
}