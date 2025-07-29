import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            d.addFirst(i);
        }

        while (d.size() != 1) {
            d.removeLast();
            d.addFirst(d.pollLast());
        }

        System.out.println(d.peekLast());
    }
}