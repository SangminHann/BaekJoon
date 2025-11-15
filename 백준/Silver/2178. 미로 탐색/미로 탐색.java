import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int y = Integer.parseInt(tmp[0]), x = Integer.parseInt(tmp[1]);
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
 
        char[][] arr = new char[y][x];
        for (int i = 0; i < y; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[y][x];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nextY = cur[0] + dy[i];
                if (nextY == y || nextY < 0) {
                    continue;
                }

                int nextX = cur[1] + dx[i];
                if (nextX == x || nextX < 0 || visited[nextY][nextX] || arr[nextY][nextX] == '0') {
                    continue;
                }

                visited[nextY][nextX] = true;
                dq.add(new int[]{nextY, nextX, cur[2] + 1});

                if (visited[y - 1][x - 1]) {
                    System.out.println(cur[2] + 1);
                    return;
                }
            }
        }

    }
}