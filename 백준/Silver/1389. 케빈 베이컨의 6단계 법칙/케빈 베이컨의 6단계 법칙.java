import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], 100000);
            arr[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int idx = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += arr[i][j];
            }

            if (min > sum) {
                idx = i;
                min = sum;
            }
        }

        System.out.println(idx);
    }
}