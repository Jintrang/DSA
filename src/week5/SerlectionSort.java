package week5;

import edu.princeton.cs.algs4.In;

public class SerlectionSort {
    public static void exch(int[] arr, int f, int a) {
        int t = arr[f];
        arr[f] = arr[a];
        arr[a] = t;
    }
    public static boolean less(int x, int y) {
        return x < y;
    } 

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int min = i;
            for (int j = i + 1; j < n - 1; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(arr, i, min);
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis();
        sort(a);
        int n = a.length;
        long end = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println(end - start);
    }
}
