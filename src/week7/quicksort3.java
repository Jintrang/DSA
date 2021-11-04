package week7;

import java.util.Scanner;

public class  quicksort3{

    static void quickSorty(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    static void quickSort(int[] ar, int low, int high){
        if(low>=high)
            return;
        int p = partition(ar, low, high);
        quickSort(ar, low, p-1);
        quickSort(ar, p+1, high);
    }

    static int partition(int[] ar, int low, int high){
        int p = ar[high];
        int i = low-1;
        for(int j=low; j<=high; j++){
            if(ar[j] < p){
                i++;
                swap(ar, i, j);
            }
        }
        swap(ar,i+1,high);
        printArray(ar);
        return i;
    }

    static void printArray(int[] ar){
        for(int n : ar)
            System.out.print(n+" ");
        System.out.println();
    }

    static void swap(int[] ar, int x, int y){
        int t = ar[x];
        ar[x] = ar[y];
        ar[y] = t;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] ar = new int[N];
        for(int i=0; i<N; i++){
            ar[i] = scanner.nextInt();
        }
        quickSorty(ar);
    }
}
