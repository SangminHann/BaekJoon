import java.util.*;
import java.io.*;

public class Main {

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

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[s] = 0;
        q.addFirst(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int cur = q.removeLast();

            visited[cur] = true;
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    dist[next] = dist[cur] + 1;
                    q.addFirst(next);
                    visited[next] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= city; i++) {
            if (dist[i] == d) {
                sb.append(i).append('\n');
            }
        }

        if (sb.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}