import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        
        int s = 1;
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && d.peekLast() == s) {
                ++s;
                d.removeLast();
            }
            if (arr[i] != s) {
                d.addLast(arr[i]);
            } else {
                ++s;
            }
        }

        while (!d.isEmpty()) {
            if (d.pollLast() != s++) {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}