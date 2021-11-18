package week8;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class jesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int count = 0;
        int n = A.size();
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        for(int i = 0; i< n ; i++) {
            queue.add(A.get(i));
        }
        while(true) {
            int size = queue.size();
            if(size > 1 ) {
                int minmin = queue.poll();
                if (minmin > k) {
                    return count;
                } else {
                    count++;
                    int min = queue.poll();
                    queue.add(minmin + 2 * min);
                }
            } else {
                if(queue.poll() < k) return -1;
                else return count;
            }

        }
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        List<Integer> arr = new ArrayList<>();
        int k = StdIn.readInt();
        for(int i = 0; i< n; i++ ) {
            int abc = StdIn.readInt();
            arr.add(abc);
        }
        System.out.println(cookies(k, arr));
    }

}
