import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {


    public static int moveD(int v) {
        return v * 2 % 10000;
    }

    public static int moveS(int v) {
        return (v == 0) ? 9999 : v - 1;
    }

    public static int moveL(int v) {
        return (v == 0) ? 0 : v * 10 % 10000 + v / 1000;

    }

    public static int moveR(int v) {
        return (v == 0) ? 0 : v / 10 + v % 10 * 1000;
    }

    static class Node {
        int n;
        StringBuilder sb;

        Node(int n, StringBuilder sb) {
            this.n = n;
            this.sb = sb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Node> dq = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            dq.addLast(new Node(a, new StringBuilder()));
            visited[a] = true;

            while(!dq.isEmpty()) {
                Node cur = dq.pollFirst();
                if (cur.n == b) {
                    result.append(cur.sb).append('\n');
                    break;
                }

                int next = moveD(cur.n);
                if (!visited[next]) {
                    dq.addLast(new Node(next, (new StringBuilder(cur.sb)).append("D")));
                    visited[next] = true;
                }

                next = moveS(cur.n);
                if (!visited[next]) {
                    dq.addLast(new Node(next, (new StringBuilder(cur.sb)).append("S")));
                    visited[next] = true;
                }

                next = moveL(cur.n);
                if (!visited[next]) {
                    dq.addLast(new Node(next, (new StringBuilder(cur.sb)).append("L")));
                    visited[next] = true;
                }

                next = moveR(cur.n);
                if (!visited[next]) {
                    dq.addLast(new Node(next, (new StringBuilder(cur.sb)).append("R")));
                    visited[next] = true;
                }
            }
        }

        System.out.println(result);
    }
}