import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String str = br.readLine();
            if (str.length() >= m) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        List<String> arr = new ArrayList<>(map.keySet());
        arr.sort((a, b) -> {
            if (map.get(b) - map.get(a) != 0) {
                return map.get(b) - map.get(a);
            } if (b.length() - a.length() != 0) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append('\n');
        }

        System.out.println(sb);
    }
}