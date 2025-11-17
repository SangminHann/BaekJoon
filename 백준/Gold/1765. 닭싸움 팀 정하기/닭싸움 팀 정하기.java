import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    static int[] root = new int[1001];

    static int findRoot(int n) {
        if (root[n] == n) {
            return n;
        }

        return root[n] = findRoot(root[n]);
    }

    static void unionRoot(int x, int y) {
        int rx, ry;

        rx = findRoot(x);
        ry = findRoot(y);

        if (rx < ry) {
            root[ry] = rx;
        } else {
            root[rx] = ry;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] enemy = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            root[i] = i;
            enemy[i] = new ArrayList<>();
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String f = st.nextToken();
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            if (f.equals("F")) {
                unionRoot(a, b);
            } else {
                enemy[a].add(b);
                enemy[b].add(a);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!enemy[i].isEmpty()) {
                for (int e : enemy[i]) {
                    if(!enemy[e].isEmpty()) {
                        for (int j : enemy[e]) {
                            if (j != e) {
                                unionRoot(j, i);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            findRoot(i);
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            s.add(root[i]);
        }

        System.out.println(s.size());
    }
}