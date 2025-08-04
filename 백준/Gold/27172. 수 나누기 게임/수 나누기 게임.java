import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] card = new int[n], sortCard = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = sortCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortCard);

        int max = sortCard[n - 1] + 1;
        int[] minus = new int[max], plus = new int[max];
        boolean[] isNum = new boolean[max];

        for (int i = 0; i < sortCard.length; i++) {
            isNum[sortCard[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = sortCard[i] * 2; j < max; j += sortCard[i]) {
                ++minus[j];
                if (isNum[j]) {
                    ++plus[sortCard[i]];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(plus[card[i]] - minus[card[i]]).append(" ");
        }

        System.out.println(sb);
    }
}