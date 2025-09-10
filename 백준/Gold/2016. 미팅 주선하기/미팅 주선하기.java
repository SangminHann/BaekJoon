import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {

    public static class Man {
        int[] prefer;
        int girl;

        public Man(int[] prefer) {
            this.girl = -1;
            this.prefer = prefer;
        }
    }

    public static class Girl {
        int[] prefer;

        public Girl(int[] prefer) {
            this.prefer = prefer;
        }
    }

    static int[] idx;
    static boolean[] selected;
    static Man[] man;
    static Girl[] girl;
    static int rst;

    public static void init() {
        for (int i = 1; i <= 5; i++) {
            man[i].girl = -1;
        }
    }

    public static void mate() {
        idx = new int[5];
        selected = new boolean[5];
        int remain = 5;
    
        while (remain != 0) {
            for (int i = 0; i < 5; i++) {
                if (!selected[i]) {
                    int girlSelect = girl[i].prefer[idx[i]];

                    if (man[girlSelect].girl == -1) {
                        man[girlSelect].girl = i + 6;
                        selected[i] = true;
                        remain--;
                    } else {
                        int rank1 = 0, rank2 = 0;
                        for (int j = 0; j < 5; j++) {
                            if (man[girlSelect].girl == man[girlSelect].prefer[j]) {
                                rank1 = j;
                                break;
                            }
                        }
                            
                        for (int j = 0; j < 5; j++) {
                            if (i + 6 == man[girlSelect].prefer[j]) {
                                rank2 = j;
                                break;
                            }
                        }

                        if (rank1 > rank2) {
                            selected[man[girlSelect].girl - 6] = false;
                            selected[i] = true;
                            man[girlSelect].girl = i + 6;
                        }
                    }

                    idx[i]++;
                }
            }
        }
    }

    static int[] arr = new int[5];
    static boolean[] visited = new boolean[5];
    static boolean flag;

    static void per(int d) {
        if (d == 5) {
            man[1].prefer = arr;
            init();
            mate();

            if (man[1].girl < rst) {
                flag = true;
            }

            return ;
        }

        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[d] = i + 6;
                per(d + 1);
                visited[i] = false;
            }

            if (flag) {
                return ;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            man = new Man[6];
            man[1] = new Man(new int[] {6, 7, 8, 9, 10});
            for (int i = 2; i <= 5; i++) {
                man[i] = new Man(Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray()
                );
            }

            girl = new Girl[5];
            for (int i = 0; i < 5; i++) {
                girl[i] = new Girl(Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray()
                );
            }

            mate();
            rst = man[1].girl;
            if (rst == 6) {
                sb.append("NO").append('\n');
            } else {
                flag = false;
                per(0);
                if (flag) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }
        
        System.out.println(sb);
    }
}