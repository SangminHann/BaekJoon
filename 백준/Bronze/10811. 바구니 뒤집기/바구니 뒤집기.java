import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, m, start, end, tmp;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			while (start < end) {
				tmp = arr[start];
				arr[start++] = arr[end];
				arr[end--] = tmp;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.print(sb);
	}
}