import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken()), b = new BigInteger(st.nextToken()), c = new BigInteger(st.nextToken());

        System.out.println(a.modPow(b, c));
    }
}