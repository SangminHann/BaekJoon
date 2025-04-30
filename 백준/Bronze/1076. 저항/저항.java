import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, long[]> resister = new HashMap<>();
        resister.put("black", new long[]{0, 1});
        resister.put("brown", new long[]{1, 10});
        resister.put("red", new long[]{2, 100});
        resister.put("orange", new long[]{3, 1000});
        resister.put("yellow", new long[]{4, 10000});
        resister.put("green", new long[]{5, 100000});
        resister.put("blue", new long[]{6, 1000000});
        resister.put("violet", new long[]{7, 10000000});
        resister.put("grey", new long[]{8, 100000000});
        resister.put("white", new long[]{9, 1000000000});

        System.out.println( (resister.get(br.readLine())[0] * 10 + resister.get(br.readLine())[0]) * resister.get(br.readLine())[1]);
    }
}