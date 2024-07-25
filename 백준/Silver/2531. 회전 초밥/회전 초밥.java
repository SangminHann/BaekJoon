import java.util.*;
import java.io.*;

public class Main {

	static boolean[] visited;
	static int cnt = 0, n, k, d, c;
	static int[] dishes;
	static boolean flag = true;

	static void recursive(int s, int idx) {
		if (s == k) {
			for (int i = 1; i < d; i++) {
				if (visited[i]) {
					++cnt;
					if (i == c) {
						flag = false;
					}
				}
			}

			return;
		}

		visited[dishes[idx]] = true;
		recursive(s + 1, (idx + 1) % n);
		visited[dishes[idx]] = false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		boolean canUse = false;
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()) + 1;
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		visited = new boolean[d];
		dishes = new int[n];

		for (int i = 0; i < n; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}

		if (k == n) {
			recursive(0, 1);
			System.out.println(cnt + ((flag) ? 1 : 0));
			return ;
		}

		for (int i = 0; i < n; i++) {
			flag = true;
			cnt = 0;
			recursive(0, i);

			if (answer == cnt) {
				canUse = (flag || canUse) ? true : false;
			} else if (answer < cnt) {
				answer = cnt;
				canUse = flag;
			}
		}

		System.out.println(answer + ((canUse) ? 1 : 0));
	}
}