import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int houseNum;
    static int cnt;
    static char[][] house;

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= houseNum || y >= houseNum || house[y][x] == '0') {
            return;
        }
        house[y][x] = '0';
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        houseNum = Integer.parseInt(st.nextToken());
        house = new char[houseNum][houseNum];

        for (int i = 0; i < houseNum; i++) {
            house[i] = br.readLine().toCharArray();
        }

        ArrayList<Integer> rst = new ArrayList<>();
        for (int i = 0; i < houseNum; i++) {
            for (int j = 0; j < houseNum; j++) {
                if (house[i][j] == '1') {
                    cnt = 0;
                    dfs(j, i);
                    rst.add(cnt);
                }
            }
        }

        Collections.sort(rst);
        System.out.println(rst.size());
        for (int num : rst) {
            System.out.println(num);
        }
        br.close();
    }
}