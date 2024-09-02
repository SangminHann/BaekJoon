import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] map;
    static boolean[] visited;
    static int v;
    static List<Integer> bfsList = new LinkedList<>(), dfsList = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e, s;

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        map = new boolean[v + 1][v + 1];

        for (int i = 0; i < e; i++) {
            int a, b;

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = true;
        }
        
        visited = new boolean[v + 1];
        dfs(s);

        visited = new boolean[v + 1];
        bfs(s);

        StringBuilder sb = new StringBuilder();
        for (int i : dfsList) {
            sb.append(i).append(' ');
        }

        sb.append('\n');
        for (int i : bfsList) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static void dfs(int s) {
        
        visited[s] = true;
        dfsList.add(s);
        
        for (int i = 0; i <= v; i++) {
            if (map[s][i]) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
        }
    }

    static void bfs(int s) {
        
        LinkedList<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            s = q.poll();
            bfsList.add(s);

            for (int i = 0; i <= v; i++) {
                if (map[s][i]) {
                    if (!visited[i]) {
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }
}