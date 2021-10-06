package week3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Scanner;

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
    public static int gcd(int a, int b) throws AssertionError {
            if (a < 0 || b < 0) {
                return gcd(Math.abs(a), Math.abs(b));
            }
            if (b > a) {
                return gcd(b, a);
            } else if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }
    }

    public static void main(String[] args) throws AssertionError {

        /*int [] a = new int[50];
        for (int i = 0; i < 50; i++){
            int number = (int) Math.random();
            number = number % 100 +1;
            a[i] = number;
        }
        int abc = StdIn.readInt();
        Arrays.sort(a);
        System.out.println(binarySearch(a, abc));*/

            System.out.println("Enter your name:");
            Scanner scan = new Scanner(System.in);
            String name="";
            String s="";
            name+=scan.nextLine();
            s+=scan.nextLine();
            scan.close();

            System.out.println("Your name is :"+name);

            System.out.println("nhap so");
            Scanner scans = new Scanner(System.in);
            int aaa = scans.nextInt();
    }
}
