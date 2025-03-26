import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, f, ans, cri, fans = -1;

        n = Integer.parseInt(br.readLine());
        f = Integer.parseInt(br.readLine());
        cri = (n / 100) * 100;
        ans = n;

        while (cri <= ans) {
            if (ans % f == 0) {
                fans = ans;
            }
            --ans;
        }
        if (fans != -1) {
            System.out.println(String.format("%02d", fans % 100));
            return;
        }

        ans = n;
        while (true) {
            if (ans % f == 0) {
                System.out.println(String.format("%02d", ans % 100));
                return;
            }
            ++ans;
        }
        
    }

}