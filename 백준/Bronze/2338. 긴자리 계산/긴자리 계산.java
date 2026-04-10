import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine()), b = new BigInteger(br.readLine());

        System.out.print(a.add(b) + "\n" + a.subtract(b) + "\n" + a.multiply(b));
    }
}