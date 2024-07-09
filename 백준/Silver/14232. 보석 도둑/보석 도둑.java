import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		long k = Long.parseLong(br.readLine());
		int cnt = 0;

		for (int i = 2; i <= k; i++) {
			if (i >= 1000000) {
				sb.append(k);
				cnt++;
				break;
			}

			while (k % i==0) {
				k /= i;
				cnt++;
				sb.append(i).append(" ");
			}
		}

        System.out.println(cnt);
		System.out.println(sb);
	}
}