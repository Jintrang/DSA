package week5;

import java.util.Stack;

public class BalancedBrackets {
    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    static boolean isIn(char a) {
        if (a == '(' || a == '{' || a == '[') return true;
        return false;
    }

    static boolean isBalance(char b, char f) {
        if (b == '(' && f == ')' || b == '{' && f == '}' || b == '[' && f == ']')
            return true;
        return false;
    }

    public static String isBalanced(String s) {
        // Write your code here
        int n = s.length();
        Stack<Character> abc = new Stack<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char res = s.charAt(i);
            if (isIn(res)) {
                abc.add(res);
                count++;
            } else {
                if (count == 0) return "NO";
                if (isBalance(abc.peek(), res)) {
                    abc.pop();
                    count--;
                } else {
                    return "NO";
                }
            }
        }
        if (count > 0) return "NO";
        return "YES";
    }

}
