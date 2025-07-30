import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    public static long recursive(long n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return n * recursive(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(recursive(Long.parseLong(br.readLine())));
    }
}