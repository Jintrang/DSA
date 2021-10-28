package week6;

import edu.princeton.cs.algs4.In;

import java.util.Random;

public class InsertionSort {
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while( j > 0 && (arr[j] < arr[j - 1])) {
                each(arr, j, j - 1);
                j--;
            }
        }
    }

    static void each(int[] arr, int x, int y) {
        int a = arr[x];
        arr[x] = arr[y];
        arr[y] = a;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        //int[] a = in.readAllInts();
        int [] a = new int[1000];
        int jj=100;
        for(int i =0; i < 1000; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(100000)+1;
            a[i] = jj;
            jj--;

        }
        long start = System.currentTimeMillis();
        insertionSort(a);
        long end = System.currentTimeMillis();
        for (int j : a) {
            System.out.println(j + " ");
        }
        System.out.println(end - start);
    }
}
