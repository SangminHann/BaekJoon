import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int  i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < 10001; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(String.valueOf(i)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}