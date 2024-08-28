import java.util.*;
import java.io.*;

public class Main {

    static List<int[]> virus = new ArrayList<>();
    static int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0};
    static int[][] map;
    static int y, x, max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[y][x];
        
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        crystallize(0, 0, 0);
        System.out.println(max);
    }

    static void crystallize(int cury, int curx, int idx) {
        if (idx == 3) {
            spread();
            return;
        }

        while (cury < y) {
            while (curx < x) {
                if (map[cury][curx] == 0) {
                    map[cury][curx] = 1;
                    crystallize(cury, curx + 1, idx + 1);
                    map[cury][curx] = 0;
                }
                ++curx;
            }

            curx = 0;
            cury++;
        }
    }

    static void spread() {

        ArrayDeque<int[]> q = new ArrayDeque<>(); // y x
        boolean[][] v = new boolean[y][x];
        int cnt = 0;

        q.addAll(virus);
        for (int[] tmp : virus) {
            v[tmp[0]][tmp[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                if (ny < 0 || ny == y) {
                    continue;
                }

                int nx = cur[1] + dx[i];
                if (nx < 0 || nx == x || map[ny][nx] != 0 || v[ny][nx]) {
                    continue;
                }

                v[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0 && !v[i][j]) {
                    ++cnt;
                }
            }
        }

        max = (max > cnt) ? max : cnt;
    }
}