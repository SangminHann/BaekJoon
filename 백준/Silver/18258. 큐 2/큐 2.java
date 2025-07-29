import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Deque<String> d = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    d.addLast(st.nextToken());
                    break;
                case "pop":
                    sb.append(d.isEmpty() ? -1 : d.pollFirst()).append('\n');
                    break;
                case "size":
                    sb.append(d.size()).append('\n');
                    break;
                case "empty":
                    sb.append(d.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(d.isEmpty() ? -1 : d.peekFirst()).append('\n');
                    break;
                default:
                    sb.append(d.isEmpty() ? -1 : d.peekLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}