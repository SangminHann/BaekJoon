import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    static boolean[][] xUsed = new boolean[9][10], yUsed = new boolean[9][10], squareUsed = new boolean[9][10];
    static int[][] board = new int[9][9];
    static List<int[]> zero = new ArrayList<>();

    public static void recursive(int depth) {
        if (depth == zero.size()) {
            for (int i = 0; i < 9; i++) {
                System.out.println(
                    Arrays.toString(board[i])
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "")
                );
            }

            System.exit(0);
        }

        int[] coor = zero.get(depth);
        for (int i = 1; i <= 9; i++) {
            if (!xUsed[coor[1]][i] && !yUsed[coor[0]][i] && !squareUsed[(coor[1] / 3) + ((coor[0] / 3) * 3)][i]) {
                xUsed[coor[1]][i] = true;
                yUsed[coor[0]][i] = true;
                squareUsed[(coor[1] / 3) + ((coor[0] / 3) * 3)][i] = true;
                board[coor[0]][coor[1]] = i;

                recursive(depth + 1);
                xUsed[coor[1]][i] = false;
                yUsed[coor[0]][i] = false;
                squareUsed[(coor[1] / 3) + ((coor[0] / 3) * 3)][i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int a = Integer.parseInt(st.nextToken());

                board[i][j] = a;
                xUsed[j][a] = true;
                yUsed[i][a] = true;
                squareUsed[(j / 3) + ((i / 3) * 3)][a] = true;
                if (a == 0) {
                    zero.add(new int[]{i, j});
                }
            }
        }

        recursive(0);
    }
}