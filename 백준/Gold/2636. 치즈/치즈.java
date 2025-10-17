import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    static List<int[]> cheese = new ArrayList<>(), melt = new LinkedList<>();
    static List<List<int[]>> empty = new ArrayList<>();
    static int[][] arr;
    static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    static int y, x, cnt = 0;

    static void outside(int _y, int _x, int change) {
        for (int i = 0; i < 4; i++) {
            int nextY = _y + dy[i], nextX = _x + dx[i];

            if (nextY < 0 || nextY == y || nextX < 0 || nextX == x) {
                continue;
            }

            if (arr[nextY][nextX] == change) {
                arr[nextY][nextX] = 2;
                outside(nextY, nextX, change);
            } 
        }
    }

    static void emptyPlace(int _y, int _x, int idx) {
        
        arr[_y][_x] = 3;
        empty.get(idx).add(new int[]{_y, _x});

        for (int i = 0; i < 4; i++) {
            int nextY = _y + dy[i], nextX = _x + dx[i];

            if (arr[nextY][nextX] == 0) {
                emptyPlace(nextY, nextX, idx);
            }
        }
    }

    static void melting() {
        cnt = 0;

        for (int i = 0; i < cheese.size(); i++) {
            int[] tmp = cheese.get(i);
            for (int j = 0; j < 4; j++) {
                if (arr[tmp[0] + dy[j]][tmp[1] + dx[j]] == 2) {
                    melt.add(new int[]{tmp[0], tmp[1]});
                    ++cnt;
                    cheese.remove(i--);
                    break;
                }
            }
        }

        while (!melt.isEmpty()) {
            arr[melt.get(0)[0]][melt.get(0)[1]] = 2;
            melt.remove(0);
        }

        if (!empty.isEmpty()) {
            for (int i = 0; i < empty.size(); i++) {
                List<int[]> tmpList = empty.get(i);
                boolean flag = false;

                for (int[] tmp : tmpList) {
                    for (int j = 0; j < 4; j++) {
                        if (arr[tmp[0] + dy[j]][tmp[1] + dx[j]] == 2) {
                            outside(tmp[0], tmp[1], 3);
                            empty.remove(i--);
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    cheese.add(new int[]{i, j});
                }
                arr[i][j] = tmp;
            }
        }

        outside(0, 0, 0);
        int idx = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j] == 0) {
                    empty.add(new LinkedList<>());
                    emptyPlace(i, j, idx);
                    idx++;
                }
            }
        }

        int time = 0;
        while (!cheese.isEmpty()) {
            melting();
            ++time;
        }

        System.out.println(time + "\n" + cnt);
    }
}