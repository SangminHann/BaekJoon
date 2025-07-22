import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.valueOf(st.nextToken()));
        }
        
        List<Integer> tmp = new ArrayList<>(arr);
        Collections.sort(tmp);
        int cnt = 0, pst = tmp.get(0);

        Map<Integer, Integer> m = new HashMap<>();
        for (int i : tmp) {
            if (i != pst) {
                pst = i;
                ++cnt;
            }

            m.put(i, cnt);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(m.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}