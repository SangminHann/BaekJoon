import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Long> bosuk = new LinkedList<>();
        int answer = 0;
        boolean flag = true;

        Long weight = Long.valueOf(br.readLine()), n = 2l;

        while (n <= weight && n <= 1000000) {

            flag = true;
            Long tmp = (long)Math.sqrt(n);
            for (Long l = 2l; l < tmp; l++) {
                if (n % l == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                while (weight % n == 0) {
                    bosuk.add(n);
                    weight /= n;
                    ++answer;
                }
            }
            ++n;
        }

        if (answer == 0) {
            System.out.println(1);
            System.out.println(weight);
            return ;
        }

        if (weight != 1) {
            ++answer;
            bosuk.add(weight);
        }
        
        System.out.println(answer);
        for (Long l : bosuk) {
            System.out.print(l + " ");
        }
    }
}