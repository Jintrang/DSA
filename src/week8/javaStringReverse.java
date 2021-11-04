package week8;

import java.util.Scanner;

public class javaStringReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int n = A.length();
        for (int i = 0; i < n / 2; i++) {
            if (A.charAt(i) != A.charAt(n - 1 - i)) {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");
    }
}
