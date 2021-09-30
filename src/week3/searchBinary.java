package week3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class searchBinary {
    public static int binarySearch(int[] a, int number) {
        int n = a.length - 1;
        int end = 0;
        while (end != n) {
            int check = (end + n) / 2;
            if(a[check] == number) {
                return check;
            } else if (a[check] > number) {
                n = check;
            } else {
                end = check;
            }
        }
    return -1;
    }

    public static void main(String[] args) {
        int [] a = new int[50];
        for (int i = 0; i < 50; i++){
            int number = (int) Math.random();
            number = number % 100 +1;
            a[i] = number;
        }
        int abc = StdIn.readInt();
        Arrays.sort(a);
        System.out.println(binarySearch(a, abc));
    }

}
