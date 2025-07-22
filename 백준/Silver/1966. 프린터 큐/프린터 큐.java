import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    public static class Docs {
        public int pri;
        public int rank;

        public Docs(int pri, int rank) {
            this.pri = pri;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine()), num, target, cnt, ans;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            cnt = 0; ans = -1;

            st = new StringTokenizer(br.readLine());
            Queue<Docs> q = new LinkedList<>();
            List<Integer> arr = new LinkedList<>();

            for (int j = 0; j < num; j++) {
                int pri = Integer.parseInt(st.nextToken());
                q.add(new Docs(pri, j));
                arr.add(pri);
            }

            Collections.sort(arr, Comparator.reverseOrder());

            while (ans == -1) {
                if (q.peek().pri == arr.get(0)) {
                    ++cnt;
                    if (q.peek().rank == target) {
                        ans = cnt;
                    }
                    q.remove();
                    arr.remove(0);
                } else {
                    q.add(q.remove());
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}