import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()), rst = 0;

        for (int i = 0; i <= a; i++) {
            if (a == sum(i)) {
                rst = i;
                break;
            } 
        }
        
        System.out.println(rst);
    }

    public static int sum(int num) {
        int rst = num;

        while (num != 0) {
            rst += (num % 10);
            num /= 10;
        }

        return rst;
    }
}