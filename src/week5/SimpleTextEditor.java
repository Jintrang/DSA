package week5;

import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String abc = "";
        Stack<String> stack = new Stack<>();
        int num2;
        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            if (num == 1) {
                stack.push(abc);
                String s = scan.next();
                abc = abc + s;
            } else if (num == 2) {
                stack.push(abc);
                num2 = scan.nextInt();
                abc = abc.substring(0, abc.length() - num2);
            } else if (num == 3) {
                num2 = scan.nextInt();
                System.out.println(abc.charAt(num2 - 1));
            } else if (num == 4) {
                abc = stack.pop();
            } else {
                System.out.println("Error");
            }
        }
    }
}