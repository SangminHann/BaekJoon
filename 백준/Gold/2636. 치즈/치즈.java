import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), cnt = 0, answer = 0, time = 0;
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, -1, 1};
        int[][] arr = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    ++cnt;
                }
                arr[i][j] = tmp;
            }
        }

        List<int[]> melt = new LinkedList<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{0, 0});
        arr[0][0] = 2;

        while (cnt != 0) {
            time++;
            while(!dq.isEmpty()) {
                int[] tmp = dq.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int nextY = tmp[0] + dy[i], nextX = tmp[1] + dx[i];

                    if (nextY == -1 || nextY == y || nextX == -1 || nextX == x || arr[nextY][nextX] == 2) {
                        continue;
                    }

                    if (arr[nextY][nextX] == 0) {
                        arr[nextY][nextX] = 2;
                        dq.addLast(new int[]{nextY, nextX});
                    } else if (arr[nextY][nextX] == 1) {
                        arr[nextY][nextX] = 3;
                        melt.add(new int[]{nextY, nextX});
                    }
                }
            }

            answer = melt.size();
            cnt -= answer;
            while (!melt.isEmpty()) {
                int[] tmp = melt.get(0);
                melt.remove(0);

                arr[tmp[0]][tmp[1]] = 2;
                dq.addLast(new int[]{tmp[0], tmp[1]});
            }
        }

        System.out.println(time + "\n" + answer);
    }
}