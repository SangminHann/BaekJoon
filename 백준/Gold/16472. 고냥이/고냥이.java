import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max, answer = 0, cnt = 0, s = 0, e = -1;
		int[] alpha = new int[26];

		max = Integer.parseInt(br.readLine());
		String str = br.readLine();

		while (++e < str.length()) {
			if (alpha[str.charAt(e) - 'a']++ == 0) {
				++cnt;
			}

			while (max < cnt) {
				if (--alpha[str.charAt(s++) - 'a'] == 0) {
					--cnt;
				}
			}

			answer = Math.max(answer, e - s + 1);
		}

		System.out.println(answer);
	}
}