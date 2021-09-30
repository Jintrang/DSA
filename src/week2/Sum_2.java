package week2;

import edu.princeton.cs.algs4.*;

public class Sum_2 {
    public static void main(String[] args) {
        In in = new In("D:\\coursera\\algs4-data\\1Kints.txt");
        int [] a = in.readAllInts();
        int n = a.length;
        boolean [] arr = new boolean[n];
        for (int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n ; j++ )
                if (a[i] + a[j] == 0 && !arr[i] && !arr[j]) {
                    System.out.println(a[i] + " " + a[j]);
                    arr[i] = true;
                    arr[j] = true;
                }
        }
    }
}
