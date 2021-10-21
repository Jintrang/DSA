package week6;

import edu.princeton.cs.algs4.In;

public class MergeSort {
    static void mergeSort(int[] a, int x, int y) {
        if (y <= x) {
            return;
        }
        int i = x + (y-x)/2;
        mergeSort(a, x, i);
        mergeSort(a, i + 1, y);
        merge(a, x, (y - x) / 2, y);
    }

    static void exch(int[] arr, int x, int y) {
        int a = arr[x];
        arr[x] = arr[y];
        arr[y] = a;
    }

    static void merge(int[] arr, int lo, int mi, int hi) {
        int[] cArr = new int[arr.length];
        int j = lo, k = mi + 1;
        for(int i = 0; i < arr.length ; i++) {
            if(j == mi){
                cArr[i] = arr[k];
                k++;
            } else if(k == hi) {
                cArr[i] = arr[j];
                j++;
            } else if(arr[j] > arr[k]) {
                cArr[i] = arr[k];
                k++;
            } else if (arr[j] <= arr[k] ) {
                cArr[i] = arr[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis();
        mergeSort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        for (int j : a) {
            System.out.println(j + " ");
        }
        System.out.println(end - start);
    }

}
