// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.*;
// import java.io.IOException;

// public class Main {

//     static int n, m, noSagak = 0, cnt = 0, rst = 65;
//     static int[] dy = {0, 1, 0, -1}, dx = {1, 0, -1, 0};
//     static char[][] office;
//     static int[][] gamsiArr;
//     static List<int[]> cctv;

//     static int gamsi(int startY, int startX, int i, int idx) {
//         int tmp = 0, y = startY + dy[i], x = startX + dx[i];

//         while (y >= 0 && y < n && x >= 0 && x < m) {
//             if (office[y][x] == '6') {
//                 break;
//             } else if (office[y][x] == '0') {
//                 office[y][x] = '#';
//                 gamsiArr[y][x] = idx;
//                 ++tmp;
//             }
//             y += dy[i];
//             x += dx[i];
//         }

//         return tmp;
//     }

//     static void reverseGamsi(int startY, int startX, int i, int idx) {
//         int y = startY + dy[i], x = startX + dx[i];

//         while (y >= 0 && y < n && x >= 0 && x < m) {
//             if (office[y][x] == '6') {
//                 break;
//             } else if (office[y][x] == '#') {
//                 if (gamsiArr[y][x] == idx) {
//                     office[y][x] = '0';
//                     gamsiArr[y][x] = 0;
//                 }
//             }
//             y += dy[i];
//             x += dx[i];
//         }
//     }

//     static void recursive(int idx) {
//         if (cctv.size() == idx) {
//             int tmp = m * n - noSagak - cnt;

//             rst = rst > tmp ? tmp : rst;
//             return;
//         }

//         int[] coor = cctv.get(idx);
//         char type = office[coor[0]][coor[1]];

//         switch (type) {
//             case '1':
//                 for (int i = 0; i < 4; i++) {
//                     int tmp = 0;
                    
//                     tmp = gamsi(coor[0], coor[1], i, idx + 1);
//                     cnt += tmp;

//                     recursive(idx + 1);
//                     cnt -= tmp;
//                     reverseGamsi(coor[0], coor[1], i, idx + 1);
//                 }
//                 break;
//             case '2':
//                 for (int i = 0; i < 2; i++) {
//                     int tmp = 0;

//                     tmp = gamsi(coor[0], coor[1], i, idx + 1);
//                     tmp += gamsi(coor[0], coor[1], i + 2, idx + 1);
//                     cnt += tmp;

//                     recursive(idx + 1);
//                     cnt -= tmp;
//                     reverseGamsi(coor[0], coor[1], i, idx + 1);
//                     reverseGamsi(coor[0], coor[1], i + 2, idx + 1);
//                 }
//                 break;
//             case '3':
//                 for (int i = 0; i < 4; i++) {
//                     int tmp = 0;

//                     tmp = gamsi(coor[0], coor[1], i, idx + 1);
//                     tmp += gamsi(coor[0], coor[1], (i + 1) % 4, idx + 1);
//                     cnt += tmp;

//                     recursive(idx + 1);
//                     cnt -= tmp;
//                     reverseGamsi(coor[0], coor[1], i, idx + 1);
//                     reverseGamsi(coor[0], coor[1], (i + 1) % 4, idx + 1);
//                 }
//                 break;
//             case '4':
//                 for (int i = 0; i < 4; i++) {
//                     int tmp = 0;

//                     tmp = gamsi(coor[0], coor[1], i, idx + 1);
//                     tmp += gamsi(coor[0], coor[1], (i + 1) % 4, idx + 1);
//                     tmp += gamsi(coor[0], coor[1], (i + 2) % 4, idx + 1);
//                     cnt += tmp;
                    
//                     recursive(idx + 1);
//                     cnt -= tmp;
//                     reverseGamsi(coor[0], coor[1], i, idx + 1);
//                     reverseGamsi(coor[0], coor[1], (i + 1) % 4, idx + 1);
//                     reverseGamsi(coor[0], coor[1], (i + 2) % 4, idx + 1);
//                 }
//                 break;
        
//             default:
//                 int tmp = 0;

//                 tmp = gamsi(coor[0], coor[1], 0, idx + 1);
//                 tmp += gamsi(coor[0], coor[1], 1, idx + 1);
//                 tmp += gamsi(coor[0], coor[1], 2, idx + 1);
//                 tmp += gamsi(coor[0], coor[1], 3, idx + 1);
//                 cnt += tmp;

//                 recursive(idx + 1);
//                 cnt -= tmp;
//                 reverseGamsi(coor[0], coor[1], 0, idx + 1);
//                 reverseGamsi(coor[0], coor[1], 1, idx + 1);
//                 reverseGamsi(coor[0], coor[1], 2, idx + 1);
//                 reverseGamsi(coor[0], coor[1], 3, idx + 1);
//                 break;
//         }
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         office = new char[n][m];
//         gamsiArr = new int[n][m];
//         cctv = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             st= new StringTokenizer(br.readLine());

//             for (int j = 0; j < m; j++) {
//                 char tmp = st.nextToken().charAt(0);

//                 if (tmp == '6') {
//                     ++noSagak;
//                 } else if (tmp != '0') {
//                     cctv.add(new int[]{i, j});
//                     ++noSagak;
//                 }
//                 office[i][j] = tmp;
//             }
//         }

//         recursive(0);

//         System.out.println(rst);
//     }
// }

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;

    static class Node implements Comparable<Node> {
        int to, w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void dijk(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.to] < cur.w) {
                continue;
            }

            if (cur.to == end) {
                return;
            }

            for (Node next : graph.get(cur.to)) {
                int d = dist[cur.to] + next.w;
                if (dist[next.to] > d) {
                    dist[next.to] = d;
                    pq.add(new Node(next.to, d));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
        }

        st = new StringTokenizer(br.readLine());
        int rst1 = 0, rst2 = 0, v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijk(1, v1);
        if (dist[v1] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return ;
        }

        rst1 += dist[v1];

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijk(v1, v2);
        if (dist[v2] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return ;
        }

        rst1 += dist[v2];

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijk(v2, n);
        if (dist[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return ;
        }

        rst1 += dist[n];

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijk(1, v2);
        if (dist[v2] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return ;
        }

        rst2 += dist[v2];

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijk(v2, v1);
        if (dist[v1] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return ;
        }

        rst2 += dist[v1];

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijk(v1, n);
        if (dist[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return ;
        }

        rst2 += dist[n];

        System.out.println(Integer.min(rst1, rst2));
    }
}