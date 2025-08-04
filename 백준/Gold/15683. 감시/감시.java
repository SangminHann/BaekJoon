import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    static int n, m, noSagak = 0, cnt = 0, rst = 65;
    static int[] dy = {0, 1, 0, -1}, dx = {1, 0, -1, 0};
    static int[][] office;
    static List<int[]> cctv;

    static int gamsi(int startY, int startX, int i, int idx) {
        int tmp = 0, y = startY + dy[i], x = startX + dx[i];

        while (y >= 0 && y < n && x >= 0 && x < m) {
            if (office[y][x] == 6) {
                break;
            } else if (office[y][x] ==  0) {
                office[y][x] = idx;
                ++tmp;
            }
            y += dy[i];
            x += dx[i];
        }

        return tmp;
    }

    static void reverseGamsi(int startY, int startX, int i, int idx) {
        int y = startY + dy[i], x = startX + dx[i];

        while (y >= 0 && y < n && x >= 0 && x < m) {
            if (office[y][x] == 6) {
                break;
            } else if (office[y][x] == idx) {
                office[y][x] = 0;
            }
            y += dy[i];
            x += dx[i];
        }
    }

    static void recursive(int idx) {
        if (cctv.size() == idx) {
            int tmp = m * n - noSagak - cnt;

            rst = rst > tmp ? tmp : rst;
            return;
        }

        int[] coor = cctv.get(idx);

        switch (office[coor[0]][coor[1]]) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    int tmp = 0;
                    
                    tmp = gamsi(coor[0], coor[1], i, idx + 7);
                    cnt += tmp;

                    recursive(idx + 1);
                    cnt -= tmp;
                    reverseGamsi(coor[0], coor[1], i, idx + 7);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    int tmp = 0;

                    tmp = gamsi(coor[0], coor[1], i, idx + 7);
                    tmp += gamsi(coor[0], coor[1], i + 2, idx + 7);
                    cnt += tmp;

                    recursive(idx + 1);
                    cnt -= tmp;
                    reverseGamsi(coor[0], coor[1], i, idx + 7);
                    reverseGamsi(coor[0], coor[1], i + 2, idx + 7);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    int tmp = 0;

                    tmp = gamsi(coor[0], coor[1], i, idx + 7);
                    tmp += gamsi(coor[0], coor[1], (i + 1) % 4, idx + 7);
                    cnt += tmp;

                    recursive(idx + 1);
                    cnt -= tmp;
                    reverseGamsi(coor[0], coor[1], i, idx + 7);
                    reverseGamsi(coor[0], coor[1], (i + 1) % 4, idx + 7);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    int tmp = 0;

                    tmp = gamsi(coor[0], coor[1], i, idx + 7);
                    tmp += gamsi(coor[0], coor[1], (i + 1) % 4, idx + 7);
                    tmp += gamsi(coor[0], coor[1], (i + 2) % 4, idx + 7);
                    cnt += tmp;
                    
                    recursive(idx + 1);
                    cnt -= tmp;
                    reverseGamsi(coor[0], coor[1], i, idx + 7);
                    reverseGamsi(coor[0], coor[1], (i + 1) % 4, idx + 7);
                    reverseGamsi(coor[0], coor[1], (i + 2) % 4, idx + 7);
                }
                break;
        
            default:
                int tmp = 0;

                tmp = gamsi(coor[0], coor[1], 0, idx + 7);
                tmp += gamsi(coor[0], coor[1], 1, idx + 7);
                tmp += gamsi(coor[0], coor[1], 2, idx + 7);
                tmp += gamsi(coor[0], coor[1], 3, idx + 7);
                cnt += tmp;

                recursive(idx + 1);
                cnt -= tmp;
                reverseGamsi(coor[0], coor[1], 0, idx + 7);
                reverseGamsi(coor[0], coor[1], 1, idx + 7);
                reverseGamsi(coor[0], coor[1], 2, idx + 7);
                reverseGamsi(coor[0], coor[1], 3, idx + 7);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        office = new int[n][m];
        cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 6) {
                    ++noSagak;
                } else if (tmp != 0) {
                    cctv.add(new int[]{i, j});
                    ++noSagak;
                }
                office[i][j] = tmp;
            }
        }

        recursive(0);

        System.out.println(rst);
    }
}