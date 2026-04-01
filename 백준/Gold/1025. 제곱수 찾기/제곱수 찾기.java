import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        long ans = - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int dy = -n; dy < n; dy++) {
                    for (int dx = -m; dx < m; dx++) {
                        if (dy == 0 && dx == 0) {
                            continue;
                        }

                        int curY = i, curX = j;
                        long num = 0;

                        while (curY >= 0 && curX >= 0 && curY < n && curX < m) {
                            num = num * 10 + arr[curY][curX];

                            long tmp = (long)Math.sqrt(num);
                            if (tmp * tmp == num) {
                                ans = Math.max(ans, num);
                            }

                            curY += dy;
                            curX += dx;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}