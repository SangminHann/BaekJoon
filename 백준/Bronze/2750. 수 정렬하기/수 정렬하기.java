import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> rst = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int  i = 0; i < n; i++) {
            rst.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(rst);

        for (int a : rst) {
            System.out.println(a);
        }
    }
}