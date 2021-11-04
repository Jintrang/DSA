package week7;

import java.util.List;

public class findTheMedian1 {
    public static int quickSortx (int [] a, int l, int r,int index)
    {
        if (l == r)
            return a[l];
        if (l < r) {
            int q = quicksort3.partition(a, l, r);
            if (q == index)
                return a[q];
            else if (q > index)
                return quickSortx(a, l, q - 1, index);
            else
                return quickSortx(a, q + 1, r, index);
        }
        return 0;
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int [] arr2 = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            arr2[i] = arr.get(i);
        }
        return quickSortx(arr2, 0, arr.size() -1, arr.size()/2);
    }
}
