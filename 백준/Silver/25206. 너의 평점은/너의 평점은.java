import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double credit = 0, grade = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double tmp = Double.parseDouble(st.nextToken());
            switch (st.nextToken()) {
                case "A+":
                    grade += tmp * 4.5;
                    break;
                case "A0":
                    grade += tmp * 4;
                    break;
                case "B+":
                    grade += tmp * 3.5;
                    break;
                case "B0":
                    grade += tmp * 3;
                    break;
                case "C+":
                    grade += tmp * 2.5;
                    break;
                case "C0":
                    grade += tmp * 2;
                    break;
                case "D+":
                    grade += tmp * 1.5;
                    break;
                case "D0":
                    grade += tmp * 1;
                    break;
                case "F":
                    break;
                default:
                    tmp = 0;
                    break;
            }
            credit += tmp;
        }
        System.out.println(grade / credit);
    }
}