import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (st.nextToken().charAt(0) == '-') {
                int cnt = 1, idx = i;
                ++i;
                while (i < n) {
                    
                    if (st.nextToken().charAt(0) != '-') {
                        break;
                    }

                    ++cnt;
                    ++i;
                }
                arr.add(new int[] {idx, cnt});
            }
        }

        arr.sort((a, b) -> {
            return b[1] - a[1];
        });

        if (arr.isEmpty()) {
            System.out.println(0);
            return ;
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = arr.get(i)[1] * 2 < arr.get(i)[0] ? arr.get(i)[0] - arr.get(i)[1] * 2 : 0; j < arr.get(i)[0]; j++) {
                ++check[j];
            }
        }

        int rst = 0, max = arr.get(0)[1];
        for (int i = 0; i < arr.size() && max == arr.get(i)[1]; i++) {
            int j = arr.get(i)[1] * 3 < arr.get(i)[0] ? arr.get(i)[0] - arr.get(i)[1] * 3 : 0;
            int k = arr.get(i)[1] * 2 < arr.get(i)[0] ? arr.get(i)[0] - arr.get(i)[1] * 2 : 0;

            for (int l = j; l < k; l++) {
                ++check[l];
            }

            int cnt = 0;
            for (int l = 0; l < n; l++) {
                if(check[l] != 0) {
                    ++cnt;
                }
            }

            for (int l = j; l < k; l++) {
                --check[l];
            }

            rst = Integer.max(cnt, rst);
        }

        System.out.println(rst);
    }
}