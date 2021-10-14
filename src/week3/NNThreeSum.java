package week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class NNThreeSum {
    private static int count(int[] a) {
        int size = a.length;
        int countSum = 0;
        for (int head = 0; head < size - 2; head++) {
            int mid = head + 1;
            int tail = size - 1;
            while (mid < tail) {
                int sum = a[head] + a[tail] + a[mid];
                if (sum == 0) {
                    countSum++;
                } else if (sum > 0) {
                    tail--;
                } else {
                    mid++;
                }
            }
        }
        return countSum;
    }

    public static void main(String[] args)  {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Arrays.sort(a);
        int count = count(a);
        StdOut.println(count);
    }

}
