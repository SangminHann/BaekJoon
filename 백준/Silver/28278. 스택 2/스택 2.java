import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> d = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "1":
                    d.addLast(st.nextToken());
                    break;
                case "2":
                    sb.append((d.isEmpty()) ? -1 : d.pollLast()).append('\n');
                    break;
                case "3":
                    sb.append(d.size()).append('\n');
                    break;
                case "4":
                    sb.append((d.isEmpty()) ? 1 : 0).append('\n');
                    break;
                case "5":
                    sb.append((d.isEmpty()) ? -1 : d.peekLast()).append('\n');
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}