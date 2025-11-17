import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int cnt = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (cnt-- > 0) {
                pq.add(Long.valueOf(st.nextToken()));
            }

            long sum = 0;
            while (pq.size() != 1) {
                long a = pq.poll(), b = pq.poll();
                sum += a + b;
                pq.add(a + b);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}