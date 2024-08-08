import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a0, a1, a2, c1, c2, n;

        StringTokenizer st = new StringTokenizer(br.readLine());
        a2 = Integer.parseInt(st.nextToken());
        a1 = Integer.parseInt(st.nextToken());
        a0 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int i, l;

        i = a2 - c1;
        l = c2 - a2;

        System.out.println(
        ((i >= 0) && (l >= 0)
        && ((a1 * a1 - 4 * i * a0 <= 0) || ((i * n * n + a1 * n + a0 >= 0) && (2 * i * n + a1 >= 0)))
        && ((a1 * a1 + 4 * l * a0 <= 0) || ((l * n * n - a1 * n - a0 >= 0) && (2 * l * n - a1 >= 0)))) ? 1 : 0);
    }
}