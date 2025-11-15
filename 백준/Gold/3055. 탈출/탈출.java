import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.cert.TrustAnchor;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int y = Integer.parseInt(tmp[0]), x = Integer.parseInt(tmp[1]);
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
        char[][] arr = new char[y][x];

        int[] start = new int[3], end = new int[2];
        Deque<int[]> water = new ArrayDeque<>();

        for (int i = 0; i < y; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < x; j++) {
                if (arr[i][j] == 'D') {
                    end = new int[]{i, j};
                } else if (arr[i][j] == 'S') {
                    start = new int[]{i, j, 0};
                } else if (arr[i][j] == '*') {
                    water.add(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[y][x];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start[0]][start[1]] = true;

        while (!dq.isEmpty()) {
            int tmpSize = water.size();

            for (int i = 0; i < tmpSize; i++) {
                int[] cur = water.pollFirst();

                for (int j = 0; j < 4; j++) {
                    int nextY = cur[0] + dy[j];
                    if (nextY < 0 || nextY == y) {
                        continue;
                    }

                    int nextX = cur[1] + dx[j];
                    if (nextX < 0 || nextX == x || arr[nextY][nextX] == 'X' || arr[nextY][nextX] == 'D' || arr[nextY][nextX] == '*') {
                        continue;
                    }

                    water.add(new int[]{nextY, nextX});
                    arr[nextY][nextX] = '*';
                }
            }

            tmpSize = dq.size();
            for (int i = 0; i < tmpSize; i++) {
                int[] cur = dq.pollFirst();

                for (int j = 0; j < 4; j++) {
                    int nextY = cur[0] + dy[j];
                    if (nextY < 0 || nextY == y) {
                        continue;
                    }

                    int nextX = cur[1] + dx[j];
                    if (nextX < 0 || nextX == x || visited[nextY][nextX] || arr[nextY][nextX] == 'X' || arr[nextY][nextX] == '*') {
                        continue;
                    }

                    dq.add(new int[]{nextY, nextX, cur[2] + 1});
                    visited[nextY][nextX] = true;

                    if (visited[end[0]][end[1]]) {
                        System.out.println(cur[2] + 1);
                        return;
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }
}