import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] stats;
    static boolean[] check;
    static int N;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stats = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                stats[i][j] = Integer.parseInt(tokens[j - 1]);
            }
        }

        DFS(0, 1);
        System.out.println(ans);
    }

    static void DFS(int x, int pos) {
        if (x == N / 2) {
            int start = 0;
            int link = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (check[i] && check[j]) {
                        start += stats[i][j];
                    }
                    if (!check[i] && !check[j]) {
                        link += stats[i][j];
                    }
                }
            }

            ans = Math.min(ans, Math.abs(start - link));
            return;
        }

        for (int i = pos; i <= N; i++) {
            check[i] = true;
            DFS(x + 1, i + 1);
            check[i] = false;
        }
    }
}
