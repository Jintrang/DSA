package week6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;

public class insertionsort1 {
    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        for(int i = n-1; i>=1; i--) {
            if(arr.get(i) < arr.get(i-1)){
                int j = i;
                int ch = arr.get(i);
                while(j>0 && arr.get(j) < arr.get(j-1)){
                    arr.set(j, arr.get(j-1));
                    j--;
                    for(int f = 0; f<n; f++) System.out.print(arr.get(f) + " ");
                    System.out.print("\n");
                }
                arr.set(j, ch);
                for(int f = 0; f<n; f++) System.out.print(arr.get(f) + " ");
                System.out.print("\n");
            }
        }

        // Write your code here

    }

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();
        int n = StdIn.readInt();
        for(int i =0; i < n; i++) {
            int ex = StdIn.readInt();
            aList.add(ex);
        }
        insertionSort1(n,aList);
    }
}
