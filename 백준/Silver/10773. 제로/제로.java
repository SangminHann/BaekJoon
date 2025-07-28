import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();

        while (n-- > 0) {
            int a = Integer.parseInt(br.readLine());

            if (a == 0) {
                d.removeLast();
            } else {
                d.addLast(a);
            }
        }

        int cnt = 0;
        for (int tmp : d) {
            cnt += tmp;
        }

        System.out.println(cnt);
    }
}