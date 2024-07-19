import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] card = br.readLine().split(" ");
		Map<String, Integer> map = new HashMap<>();

		for (String s : card) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		br.readLine();
		String[] answer = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		for (String s : answer) {
			sb.append(map.getOrDefault(s, 0)).append(" ");
		}
		
		System.out.println(sb);
	}
}