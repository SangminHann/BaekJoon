import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> rmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(i + 1, s);
            rmap.put(s, i + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            if (isNum(s)) {
                sb.append(map.get(Integer.parseInt(s)));
            } else {
                sb.append(rmap.get(s));
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}