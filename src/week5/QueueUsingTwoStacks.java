package week5;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class QueueUsingTwoStacks {
    public static class MyQueue {
        int[] arr;
        int size;

        public MyQueue(int n) {
            arr = new int[n];
            size = 0;
        }

        public void enqueue(int n) {
            arr[size++] = n;
        }

        public int dequeue() {
            if (size == 0) throw new NoSuchElementException("null");
            int res = arr[0];
            for (int i = 0; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[size - 1] = Integer.parseInt(null);
            size--;
            return res;
        }

        public void print() {
            if(size == 0) throw new NoSuchElementException("null");
            System.out.println(arr[0]);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        MyQueue abc = new MyQueue(n);
        for(int i = 0; i < n; i++) {
            int type = scan.nextInt();
            if (type == 1) {
                int x = scan.nextInt();
                abc.enqueue(x);
            } else if (type == 2) {
                abc.dequeue();
            } else {
                abc.print();
            }
        }
    }
}
