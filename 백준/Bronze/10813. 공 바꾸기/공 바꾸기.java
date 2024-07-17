import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, a, b, tmp;
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}