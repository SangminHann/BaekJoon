import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static int n;
    static int[] dist;
    static boolean[] visit;
    static List<Node>[] arr;

    static class Node implements Comparable<Node> {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static void dijkstra(int s, int end) {
        Arrays.fill(visit, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.v]) {
                continue;
            }

            visit[cur.v] = true;
            if (cur.v == end) {
                break;
            }

            for (Node next : arr[cur.v]) {
                if (!visit[next.v] && dist[next.v] > dist[cur.v] + next.cost) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        visit = new boolean[n + 1];

        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken()), cost = Integer.parseInt(st.nextToken());

            arr[v].add(new Node(w, cost));
            arr[w].add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
        
        dijkstra(v2, v1);
        long cand1 = dist[v1], cand2 = dist[v1];
        dijkstra(1, v1);
        cand1 += dist[v1];
        dijkstra(v2, n);
        cand1 += dist[n];

        dijkstra(1, v2);
        cand2 += dist[v2];
        dijkstra(v1, n);
        cand2 += dist[n];

        long rst = (cand1 > cand2) ? cand2 : cand1;
        System.out.println((rst >= Integer.MAX_VALUE) ? -1 : rst);
    }
}