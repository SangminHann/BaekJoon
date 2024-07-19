import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[n + 1];
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i]) {
				continue;
			}

			for (int j = i + i; j <= n; j += i) {
				isPrime[j] = true;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				continue;
			}

			arr.add(i);
		}

		arr.add(0);

		int s = 0, e = 0, sum = 0, cnt = 0;
		while (s <= e) {
			if (sum < n) {
				sum += arr.get(e++);
			} else if (sum == n) {
				sum += arr.get(e++);
				++cnt;
			} else {
				sum -= arr.get(s++);
			}

			if (e == arr.size()) {
				break;
			}
		}

		System.out.println(cnt);
	}
}