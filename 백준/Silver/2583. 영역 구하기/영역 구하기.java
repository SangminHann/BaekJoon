import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static boolean[][] arr;
    static int X, Y;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, 1, -1};
    static int roomCnt;

    static void dfs(int y, int x) {
        arr[y][x] = true;
        ++roomCnt;
        int nx, ny;

        for (int i = 0; i < 4; i++) {
            ny = y + dy[i];
            if (ny == Y || ny < 0) {
                continue;
            }

            nx = x + dx[i];
            if (nx == X || nx < 0 || arr[ny][nx]) {
                continue;
            }

            dfs(ny, nx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> room = new ArrayList<>();

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int x1, y1, x2, y2, cnt = 0, n = Integer.parseInt(st.nextToken());
        arr = new boolean[Y][X];


        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    arr[i][j] = true;
                }
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (arr[i][j]) {
                    continue;
                }
                roomCnt = 0;
                ++cnt;
                dfs(i, j);
                room.add(roomCnt);
            }
        }
        room.sort(null);
        System.out.println(cnt);

        for (Integer a : room) {
            System.out.print(a + " ");
        }
    }
}