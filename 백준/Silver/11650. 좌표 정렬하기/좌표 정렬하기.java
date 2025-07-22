import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    public static class Coordinate implements Comparable<Coordinate> {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Coordinate> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(
                new Coordinate(
                    Integer.parseInt(st.nextToken()), 
                    Integer.parseInt(st.nextToken())
                )
            );
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Coordinate c : arr) {
            sb.append(c.x).append(" ").append(c.y).append("\n");
        }
        System.out.println(sb);
    }
}