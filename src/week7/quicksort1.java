package week7;

import java.util.ArrayList;
import java.util.List;

public class quicksort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        int n = arr.size();
        int x = arr.get(0);
        for(int i = 1; i< n; i++) {
            if(arr.get(i) < x) res.add(arr.get(i));
        }
        res.add(x);
        for(int i = 1; i< n; i++) {
            if(arr.get(i) > x) res.add(arr.get(i));
        }
        return res;
    }
}
