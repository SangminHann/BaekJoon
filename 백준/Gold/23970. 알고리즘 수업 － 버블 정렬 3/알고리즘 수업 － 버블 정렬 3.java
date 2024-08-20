import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] arr1 = Arrays.stream(tmp).mapToInt(Integer::parseInt).toArray();
        tmp = br.readLine().split(" ");
        int[] arr2 = Arrays.stream(tmp).mapToInt(Integer::parseInt).toArray();

        if (Arrays.equals(arr1, arr2)) {
            System.out.println(1);
            return;
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    int t = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = t;
                    if (arr1[j] == arr2[j] && arr1[j + 1] == arr2[j + 1] && Arrays.equals(arr1, arr2)) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}