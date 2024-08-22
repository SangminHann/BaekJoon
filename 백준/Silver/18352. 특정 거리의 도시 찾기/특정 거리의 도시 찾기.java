import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v;
        int cost;

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
        int city, road, d, s;
        StringTokenizer st = new StringTokenizer(br.readLine());

        city = Integer.parseInt(st.nextToken());
        road = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] dist = new int[city  + 1];
        boolean[] visited = new boolean[city + 1];
        List<Integer>[] graph = new ArrayList[city + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        int a, b;
        for (int i = 0; i < road; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        PriorityQueue<Node> pq = new  PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) {
                continue;
            }

            visited[cur.v] = true;
            for (int next : graph[cur.v]) {
                if (!visited[next] && (dist[next] > dist[cur.v] + 1)) {
                    dist[next] = dist[cur.v] + 1;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= city; i++) {
            if (dist[i] == d) {
                System.out.println(i);
                ++cnt;
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        }
    }
}