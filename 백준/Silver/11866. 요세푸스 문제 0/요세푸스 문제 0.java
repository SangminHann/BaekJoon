import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]) - 1;

        List<Integer> arr = new LinkedList<>();
        List<Integer> rst = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        int i = 0;
        while (!arr.isEmpty()) {
            i = (i + k) % arr.size();
            rst.add(arr.get(i));
            arr.remove(i);
        }
        
        System.out.println(
            rst.toString()
                .replace('[', '<')
                .replace(']', '>')
        );
    }
}