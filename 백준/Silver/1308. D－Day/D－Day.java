import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sY, sM, sD, eY, eM, eD;
        
        sY = Integer.parseInt(st.nextToken());
        sM = Integer.parseInt(st.nextToken());
        sD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        eY = Integer.parseInt(st.nextToken());
        eM = Integer.parseInt(st.nextToken());
        eD = Integer.parseInt(st.nextToken());

        if (eY - sY > 1000 || (eY - sY == 1000 && sM <= eM && sD <= eD)) {
            System.out.println("gg");
            return ;
        }

        LocalDate start = LocalDate.of(sY, sM, sD);
        LocalDate end = LocalDate.of(eY, eM, eD);

        System.out.println("D-" + start.until(end, ChronoUnit.DAYS));
    }

}