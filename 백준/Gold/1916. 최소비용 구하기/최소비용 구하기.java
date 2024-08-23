import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city, bus, s, e;
        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[city + 1];
        int[] dist = new int[city + 1];
        List<Node> []graph = new ArrayList[city + 1];

        for (int i = 0; i <= city; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a, b, cost;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.v]) {
                continue;
            } if (cur.v == e) {
                break;
            }

            visited[cur.v] = true;
            for (Node next : graph[cur.v]) {
                if (!visited[next.v] && (dist[next.v] > dist[cur.v] + next.cost)) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        System.out.println(dist[e]);
    }
}