package week6;

import java.util.List;

public class insetionsort2 {
    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 0; i < n - 1; i++) {
            if(arr.get(i+1) < arr.get(i)){
                int j = i+1;
                while(j > 0 && arr.get(j) < arr.get(j-1)) {
                    arr.add(j-1, arr.get(j));
                    arr.remove(j + 1);
                    j--;
                }
            }
            for(int f = 0; f<n; f++) System.out.print(arr.get(f) + " ");
            System.out.print("\n");
        }
    }
}
