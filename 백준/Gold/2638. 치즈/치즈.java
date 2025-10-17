import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), time = 0;
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, -1, 1};
        int[][] arr = new int[y][x];
        Deque<int[]> cheese = new ArrayDeque<>();

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    cheese.addLast(new int[]{i, j});
                }
                arr[i][j] = tmp;
            }
        }

        Deque<int[]> dq = new ArrayDeque<>(), melt = new ArrayDeque<>();
        dq.addLast(new int[]{0, 0});
        arr[0][0] = 2;

        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i], nextX = tmp[1] + dx[i];

                if (nextY == y || nextY == -1 || nextX == x || nextX == -1 || arr[nextY][nextX] != 0) {
                    continue;
                }

                arr[nextY][nextX] = 2;
                dq.addLast(new int[]{nextY, nextX});
            }
        }

        int cnt = cheese.size();
        while (!cheese.isEmpty()) {
            time++;
            for (int j = 0, k = cnt; j < k; j++) {
                int[] tmp = cheese.pollFirst();
                int contact = 0;

                for (int i = 0; i < 4; i++) {
                    int nextY = tmp[0] + dy[i], nextX = tmp[1] + dx[i];

                    if (nextY == -1 || nextY == y || nextX == -1 || nextX == x || arr[nextY][nextX] != 2) {
                        continue;
                    }

                    ++contact;
                }

                if (contact > 1) {
                    --cnt;
                    arr[tmp[0]][tmp[1]] = 0;
                    melt.addLast(tmp);
                } else {
                    cheese.addLast(tmp);
                }
            }


            arr[melt.peekFirst()[0]][melt.peekFirst()[1]] = 2;

            while (!melt.isEmpty()) {
                int[] tmp = melt.pollFirst();
                arr[tmp[0]][tmp[1]] = 2;

                for (int i = 0; i < 4; i++) {
                    int nextY = tmp[0] + dy[i], nextX = tmp[1] + dx[i];

                    if (nextY == -1 || nextY == y || nextX == -1 || nextX == x || arr[nextY][nextX] != 0) {
                        continue;
                    }

                    arr[nextY][nextX] = 2;
                    melt.addLast(new int[]{nextY, nextX});

                }
            }
        }

        System.out.println(time);
    }
}