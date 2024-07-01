import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] sort = new int[26];

        for (char ch : str.toCharArray()) {
            sort[(int)(ch - 'A')] += 1;
        }

        int oddCnt = 0, oddIdx = 0;
        for (int i = 0; i < 26; i++) {
            
            if (sort[i] % 2 == 1) {
                ++oddCnt;
                oddIdx = i;
                sort[i] -= 1;
            }
        }

        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        char[] answer = new char[str.length()];
        if (oddCnt == 1) {
            answer[str.length() / 2] = (char)(oddIdx + 'A');
        }

        int s = 0, e = str.length() - 1;
        for (int i = 0; i < 26; i++) {
            while (sort[i] != 0) {
                sort[i] -= 2;
                answer[s++] = answer[e--] = (char)(i + 'A');
            }
        }

        System.out.println(String.valueOf(answer));
    }
}