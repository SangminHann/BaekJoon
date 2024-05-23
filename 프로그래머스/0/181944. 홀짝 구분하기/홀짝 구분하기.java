import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = " is ";
        
        str += n % 2 == 0 ? "even" : "odd";
        System.out.print(n + str);
    }
}