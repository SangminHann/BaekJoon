import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    static class Coor {
        int x;
        int d;
        
        public Coor(int x, int d) {
            this.d = d;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] visited = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int su = Integer.parseInt(st.nextToken()), bro = Integer.parseInt(st.nextToken()), cnt = 0;

        visited[su] = 1;
        visited[bro] = Integer.MAX_VALUE;
        Deque<Coor> dq = new ArrayDeque<>();
        dq.addLast(new Coor(su, 0));

        while (!dq.isEmpty()) {
            Coor cur = dq.pollFirst();

            if (cur.x == bro) {
                if (cur.d < visited[bro]) {
                    cnt = 0;
                    visited[bro] = cur.d;
                } else if (cur.d > visited[bro]) {
                    continue;
                }
                ++cnt;
                continue;
            }

            int nextX = cur.x + 1;
            if (nextX <= 100000 && (visited[nextX] == 0 || visited[nextX] >= cur.d + 1)) {
                dq.addLast(new Coor(nextX, cur.d + 1));
                visited[nextX] = cur.d + 1;
            }

            nextX = cur.x - 1;
            if (nextX >= 0 && (visited[nextX] == 0 || visited[nextX] >= cur.d + 1)) {
                dq.addLast(new Coor(nextX, cur.d + 1));
                visited[nextX] = cur.d + 1;
            }

            nextX = cur.x * 2;
            if (nextX <= 100000 && (visited[nextX] == 0 || visited[nextX] >= cur.d + 1)) {
                dq.addLast(new Coor(nextX, cur.d + 1));
                visited[nextX] = cur.d + 1;
            }
        }

        System.out.println(visited[bro]);
        System.out.println(cnt);
    }
}