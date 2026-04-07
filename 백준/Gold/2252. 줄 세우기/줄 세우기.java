import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for (int next : graph[now]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
