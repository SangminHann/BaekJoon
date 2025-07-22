import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine()), a = sugar / 5, rst;

        while (a >= 0) {
            if ((sugar - (a * 5)) % 3 == 0) {
                break;
            }
            --a;
        }

        if (a == -1) {
            rst = -1;
        } else {
            rst = a + ((sugar - (a * 5)) / 3);
        }

        System.out.println(rst);
    }
}