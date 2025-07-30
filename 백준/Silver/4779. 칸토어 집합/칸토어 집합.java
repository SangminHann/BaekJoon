import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {

    public static void makeCantor(char[] arr, int s, int len) {
        if (len == 1) {
            return;
        }

        int div = len / 3;
        for (int i = s + div; i < s + 2 * div; i++) {
            arr[i] = ' ';
        }

        makeCantor(arr, s, div);
        makeCantor(arr, s + div * 2, div);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            char[] arr = new char[(int) Math.pow(3, n)];

            Arrays.fill(arr, '-');
            makeCantor(arr, 0, arr.length);
            sb.append(new String(arr)).append('\n');
        }

        System.out.println(sb);
    }
}