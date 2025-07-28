import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> sub = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            sub.add(arr.get(i) - arr.get(i - 1));
        }

        int d = sub.get(0);
        for (int i = 1; i < n - 1; i++) {
            d = gcd(d, sub.get(i));

            if (d == 1) {
                break;
            }
        }

        System.out.println((arr.get(n - 1) - arr.get(0)) / d + 1 - n);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}

