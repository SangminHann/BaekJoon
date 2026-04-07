import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
        
        boolean[] student = new boolean[n + 1];
        int[] indegree = new int[n + 1];
        List<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken()), cur = Integer.parseInt(st.nextToken());
            student[prev] = true;
            student[cur] = true;

            arr[prev].add(cur);
            indegree[cur]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (student[i] && indegree[i] == 0) {
                dq.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            sb.append(cur).append(" ");
            for (int i : arr[cur]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    dq.addLast(i);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!student[i]) {
                sb.append(i).append(" ");
            }
        }
        
        System.out.println(sb);
    }
}