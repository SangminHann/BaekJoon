import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] isQ = br.readLine().split(" ");
        String[] init = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] seqC = br.readLine().split(" ");

        Deque<String> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (isQ[i].equals("0")) {
                d.addFirst(init[i]);
            }
        }

        for (int i = 0; i < m; i++) {
            d.addLast(seqC[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(d.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}