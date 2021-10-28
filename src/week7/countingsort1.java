package week7;

import java.util.ArrayList;
import java.util.List;

public class countingsort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int n = arr.size();

        List<Integer> arrList = new ArrayList<>();
        for(int i =0; i< 100; i++) {
            arrList.add(0);
        }

        for(int i = 0; i< n; i++) {
            int x = arr.get(i);
            int k = arrList.get(x);
            arrList.set(x, k+1);
        }
        return arrList;
    }
}
