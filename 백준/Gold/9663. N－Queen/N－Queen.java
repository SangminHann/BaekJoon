import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int n, cnt = 0;
    static int[] board;
    static boolean[] isQueen;

    public static boolean checkQueen(int idx) {
        if (isQueen[board[idx]]) {
            return false;
        }

        for (int i = 0; i < idx; i++) {
            if (Math.abs(i - idx) == Math.abs(board[i] - board[idx])) {
                return false;
            }
        }

        return true;
    }

    public static void nQueen(int idx) {
        if (idx == n) {
            ++cnt;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[idx] = i;

            if (checkQueen(idx)) {
                isQueen[i] = true;
                nQueen(idx + 1);
                isQueen[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n];
        isQueen = new boolean[n];

        nQueen(0);
        System.out.println(cnt);
    }
}