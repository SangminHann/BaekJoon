import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.IOException;

public class Main {

    public static class Node implements Comparable<Node> {

        int n;

        public Node(int n) {
            this.n = n;
        }

        @Override
        public int compareTo(Node o) {
            if (Math.abs(this.n) == Math.abs(o.n)) {
                return this.n - o.n;
            }
            return Math.abs(this.n) - Math.abs(o.n);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        while (t-- > 0) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll().n).append('\n');
                }
            } else {
                pq.add(new Node(a));
            }
        }

        System.out.println(sb);
    }
}