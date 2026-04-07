import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());

        int[] problem = new int[n + 1];
        int[] indegree = new int[n + 1], node = new int[n + 1];
        List<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken()), cur = Integer.parseInt(st.nextToken());

            arr[prev].add(cur);
            indegree[cur]++;
            problem[prev] = 1;
            problem[cur] = (problem[cur] == 1) ? 1 : 2;
        }

        for (int i = 1; i <= n; i++) {
            if (problem[i] == 1) {
                for (int j = i + 1; j <= n; j++) {
                    node[j]++;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } 
            return a[1] - b[1];
        });

        for (int i = 1; i <= n; i++) {
            if (problem[i] == 0) {
                pq.add(new int[]{i, node[i]});
            } else if (indegree[i] == 0) {
                pq.add(new int[]{i, 0});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll()[0];
            sb.append(cur).append(" ");

            for (int i : arr[cur]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    pq.add(new int[]{i, 0});
                }
            }
        }

        System.out.println(sb);
    }
}