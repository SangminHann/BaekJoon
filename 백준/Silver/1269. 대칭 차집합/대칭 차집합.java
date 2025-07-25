import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Set<Integer> a = new HashSet<>(), b = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> union = new HashSet<>(a), inter = new HashSet<>(a);
        union.addAll(b);
        inter.retainAll(b);
        union.removeAll(inter);

        System.out.println(union.size());
    }
}
