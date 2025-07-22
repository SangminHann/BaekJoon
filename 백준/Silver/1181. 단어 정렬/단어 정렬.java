import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> tmp = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            tmp.add(br.readLine());
        }

        List<String> arr = new ArrayList<>(tmp);
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }

                return a.length() - b.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
