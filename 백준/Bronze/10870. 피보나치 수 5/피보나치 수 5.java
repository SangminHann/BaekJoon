import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int Fi(int n) {
        if (n == 1) {
            return 1;
        } if (n == 0) {
            return 0;
        }

        return Fi(n - 1) + Fi(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Fi(Integer.parseInt(br.readLine())));
    }
}