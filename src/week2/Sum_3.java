package week2;

import edu.princeton.cs.algs4.*;

public class Sum_3 {
    public static void main(String[] args) {
        In in = new In("D:\\coursera\\algs4-data\\1Kints.txt");
        int [] a = in.readAllInts();
        int n = a.length;
        boolean [] arr = new boolean[n];
        for (int i = 0; i < n - 2; i++)
            for(int j = i + 1; j < n - 1 ; j++ )
                for (int k = j + 1; k < n ; k++)
                    if (a[i] + a[j] + a[k] == 0 && !arr[i] && !arr[j] && !arr[k]) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        arr[i] = true;
                        arr[j] = true;
                        arr[k] = true;
                    }
    }
}
