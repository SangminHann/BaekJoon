import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[a + 1];

        for (int i = 1; i <= a; i++) {
            arr[i] = true;
        }

        StringBuilder sb = new StringBuilder("<");
        int cnt = 0, mv = 0, idx = -1;
        while (true) {
            mv = 0;
            while (mv < b) {
                idx = ++idx % (a + 1);
                if (arr[idx]) {
                    mv++;
                }
            }

            ++cnt;
            sb.append(idx);
            arr[idx] = false;
            if (cnt == a) {
                break;
            }
            sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb);
    }
}