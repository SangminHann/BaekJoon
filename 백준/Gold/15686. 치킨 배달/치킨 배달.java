import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {

    public static List<House> chicken = new ArrayList<>(), house = new ArrayList<>();
    public static int arr[];
    public static int m, rst = Integer.MAX_VALUE;
    
    public static class House {
        public int r;
        public int c;

        public House (int r, int c) {
            this.r = r;
            this.c = c;
        }
    } 

    public static void recursive(int cnt, int i) {
        if (cnt == m) {
            int tmp, sum = 0, cal;

            for (int j = 0; j < house.size(); j++) {
                tmp = Integer.MAX_VALUE;

                for (int k = 0; k < m; k++) {
                    cal = Math.abs(chicken.get(arr[k]).r  - house.get(j).r) + Math.abs(chicken.get(arr[k]).c -house.get(j).c);
                    tmp = tmp > cal ? cal : tmp;
                }
                sum += tmp;
            }

            rst = rst > sum ? sum : rst;
            return;
        }

        for (int j = i; j < chicken.size(); j++) {
            arr[cnt] = j;
            recursive(cnt + 1, j + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    house.add(new House(i, j));
                } else if (a == 2) {
                    chicken.add(new House(i, j));
                }
            }
        }

        recursive(0, 0);
        System.out.println(rst);
    }
}