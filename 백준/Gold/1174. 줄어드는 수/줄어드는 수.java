import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n > 1023) {
            System.out.println(-1);
            return;
        }

        long[] arr = new long[1023];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        int idx = 10, p = 1;
        while (idx < n) {
            for (long s = 0, e = arr[p] % 10; s < e; s++) {
                arr[idx++] = arr[p] * 10 + s;
            }
            ++p;
        }

        System.out.println(arr[n - 1]);
    }
}