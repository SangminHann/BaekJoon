import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static String s;

    static int cntWin(char c) {
        int cnt = 0;

        if (s.charAt(0) == c && s.charAt(4) == c && s.charAt(8) == c) {
            ++cnt;
        } if (s.charAt(2) == c && s.charAt(4) == c && s.charAt(6) == c) {
            ++cnt;
        }

        for (int i =  0; i < 3; i++) {
            if (s.charAt(i) == c && s.charAt(i + 3) == c && s.charAt(i + 6) == c) {
                ++cnt;
            }   if (s.charAt(i * 3) == c && s.charAt(i * 3 + 1) == c && s.charAt(i * 3 + 2) == c) {
                ++cnt;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        

        while (!(s = br.readLine()).equals("end")) {
            int o = 0, x = 0;

            for (int i = 0; i < 9; i++) {
                if (s.charAt(i) == 'O') {
                    ++o;
                } else if (s.charAt(i) == 'X') {
                    ++x;
                }
            }

            if (o > x) {
                sb.append("invalid\n");
                continue;
            } if (o + 1 < x) {
                sb.append("invalid\n");
                continue;
            }

            int oWin = cntWin('O'), xWin = cntWin('X');
            
            if (xWin == 0 && oWin == 0 && x + o != 9) {
                sb.append("invalid\n");
                continue;
            } if (xWin > 0 && o == x) {
                sb.append("invalid\n");
                continue;
            } if (xWin > 0 && oWin > 0) {
                sb.append("invalid\n");
                continue;
            } if (oWin > 0 && o != x) {
                sb.append("invalid\n");
                continue;
            }
            sb.append("valid\n");
        }

        System.out.println(sb);
    }

}
