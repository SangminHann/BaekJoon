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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v, e, s;
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];
        List<Node>[] graph = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        int a, b, cost;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.v]) {
                continue;
            }

            visited[cur.v] = true;

            for (Node next : graph[cur.v]) {
                if (!visited[next.v] && (dist[next.v] > dist[cur.v] + next.cost)) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }

        System.out.print(sb);
    }
}