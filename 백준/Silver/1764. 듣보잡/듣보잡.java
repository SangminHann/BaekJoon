import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Set<String> s = new HashSet<>();
        List<String> arr = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            s.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (s.contains(str)) {
                arr.add(str);
            }
        }

        Collections.sort(arr);
        System.out.println(arr.size());

        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
