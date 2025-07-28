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
            if (arr[i] != s) {
                while (!d.isEmpty() && d.peekLast() == s) {
                    ++s;
                    d.removeLast();
                }
                d.addLast(arr[i]);
            } else {
                ++s;
            }
        }

        boolean flag = true;
        while (!d.isEmpty()) {
            if (d.pollLast() != s++) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "Nice" : "Sad");
    }
}