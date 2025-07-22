import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
        String[] board = new String[y];
        for (int i = 0; i < y; i++) {
            board[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE, cnt;
        for (int i = 0; i <= y - 8; i++) {
            for (int j = 0; j <= x - 8; j++) {
               // w
                cnt = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (k % 2 == 0) {
                            if (l % 2 == 0) {
                                if (board[i + k].charAt(j + l) != 'W') {
                                    ++cnt;
                                }
                            } else {
                                if (board[i + k].charAt(j + l) != 'B') {
                                    ++cnt;
                                }
                            }
                        } else {
                            if (l % 2 == 0) {
                                if (board[i + k].charAt(j + l) != 'B') {
                                    ++cnt;
                                }
                            } else {
                                if (board[i + k].charAt(j + l) != 'W') {
                                    ++cnt;
                                }
                            }
                        }
                    }
                }
                min = (min > cnt) ? cnt : min;

                // b
                cnt = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (k % 2 == 0) {
                            if (l % 2 == 0) {
                                if (board[i + k].charAt(j + l) != 'B') {
                                    ++cnt;
                                }
                            } else {
                                if (board[i + k].charAt(j + l) != 'W') {
                                    ++cnt;
                                }
                            }
                        } else {
                            if (l % 2 == 0) {
                                if (board[i + k].charAt(j + l) != 'W') {
                                    ++cnt;
                                }
                            } else {
                                if (board[i + k].charAt(j + l) != 'B') {
                                    ++cnt;
                                }
                            }
                        }
                    }
                }
                min = (min > cnt) ? cnt : min;
            }
        }

        System.out.println(min);
    }
}
