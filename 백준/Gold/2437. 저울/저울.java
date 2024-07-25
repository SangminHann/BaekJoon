import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, sum = 0;
		n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (sum + 1 < arr[i]) {
				break;
			}
			sum += arr[i];
		}

		System.out.println(sum + 1);
	}
}