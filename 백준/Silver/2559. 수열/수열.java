import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken());
        int[] sum = new int[n - a + 1], arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < a; i++) {
            sum[0] += arr[i];
        }

        for (int s = 0, e = a, i = 1; e < n; e++, s++, i++) {
            sum[i] = sum[i - 1] + arr[e] - arr[s];
        }

        int rst = Integer.MIN_VALUE;
        for (int i : sum) {
            rst = Integer.max(i, rst);
        }

        System.out.println(rst);
    }
}