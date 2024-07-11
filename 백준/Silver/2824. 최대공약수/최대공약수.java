import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();
		BigInteger a = Arrays.stream(br.readLine().split(" "))
							.map(BigInteger::new)
							.reduce(BigInteger.ONE, BigInteger::multiply);
		br.readLine();
		BigInteger b = Arrays.stream(br.readLine().split(" "))
							.map(BigInteger::new)
							.reduce(BigInteger.ONE, BigInteger::multiply);

		String answer = a.gcd(b).toString();
		answer = answer.length() > 9 ? answer.substring(answer.length() - 9) : answer;
		System.out.println(answer);
	}
}