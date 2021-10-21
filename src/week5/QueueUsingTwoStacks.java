package week5;
import java.util.*;

public class QueueUsingTwoStacks {

        public static void enqueue(Stack<Integer> sIn, int n) {
            sIn.push(n);
        }

        public static int dequeue(Stack<Integer> sIn, Stack<Integer> sOut) {
            if(sOut.empty()) {
                while(!sIn.empty()){
                    sOut.push(sIn.pop());
                }
            }
            return sOut.pop();
        }

        public static void print(Stack<Integer> sIn, Stack<Integer> sOut) {
            if(sOut.empty()) {
                while(!sIn.empty()){
                    sOut.push(sIn.pop());
                }
            }
            System.out.println(sOut.peek());
        }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> sIn = new Stack<>();
        Stack<Integer> sOut = new Stack<>();
        for(int i = 0; i < n; i++) {
            int type = scan.nextInt();
            if (type == 1) {
                int x = scan.nextInt();
                enqueue(sIn,x);
            } else if (type == 2) {
                dequeue(sIn, sOut);
            } else {
                print(sIn, sOut);
            }
        }
    }
}
