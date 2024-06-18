import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n], ansArr = new int[n];
            String[] tmp = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tmp[i]);
            }

            Arrays.sort(arr);
            ansArr[n / 2] = arr[n - 1];
            int answer = 0, r = n / 2 + 1, l = n / 2 - 1;

            for (int i = n - 2; i > -1;) {
                if (r != n) {
                    ansArr[r++] = arr[i--];
                }
                if (l != -1) {
                    ansArr[l--] = arr[i--];
                }
            }

            for (int i = 1; i < n; i++) {
                answer = Math.max(answer, Math.abs(ansArr[i - 1] - ansArr[i]));
            }

            System.out.println(Math.max(answer, Math.abs(ansArr[0] - ansArr[n - 1])));
        }
    }
}