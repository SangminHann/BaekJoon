import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static int[] arr = new int[100 + 1];

    static void reverse(int s, int e) {

        for (int i = 0; s + i <= (s + e) / 2; i++) {
            int tmp = arr[s + i];
            arr[s + i] = arr[e - i];
            arr[e - i] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            
            reverse(s, e);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}