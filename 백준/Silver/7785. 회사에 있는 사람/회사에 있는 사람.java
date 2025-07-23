import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> s = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken(), state = st.nextToken();

            if (state.equals("enter")) {
                s.add(name);
            } else {
                s.remove(name);
            }
        }

        List<String> arr = new ArrayList<>(s);
        Collections.sort(arr, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : arr) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}