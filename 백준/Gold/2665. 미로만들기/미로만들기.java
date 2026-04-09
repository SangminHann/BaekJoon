import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dy = {0, 0, 1, -1}, dx = {1, -1, 0, 0};
        int n = Integer.parseInt(br.readLine());

        int[][] visit = new int[n][n];
        boolean[][] arr = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = ((s.charAt(j) - '0') == 1) ? true : false;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0}); // y, x, 부순 벽
        visit[0][0] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == n - 1 && cur[1] == n - 1) {
                System.out.println(cur[2]);
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                if (y < 0 || y >= n) {
                    continue;
                }

                int x = cur[1] + dx[i];
                if (x < 0 || x >= n) {
                    continue;
                }

                if (arr[y][x] && visit[y][x] > cur[2]) {
                    pq.add(new int[]{y, x, cur[2]});
                    visit[y][x] = cur[2];
                } else if (!arr[y][x] && visit[y][x] > cur[2] + 1) {
                    pq.add(new int[]{y, x, cur[2] + 1});
                    visit[y][x] = cur[2] + 1;
                }
            }
        }

    }
}