package week7;

import java.util.List;

public class tutorial_Intro {

    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int in = 0;
        int n = arr.size();
        in = binarySearch(arr, 0, n, V);

        return in;
    }

    private static int binarySearch(List<Integer> arr, int l, int r, int v) {
        if(r > l) {
            int mid = (l-r)/2;

            if(arr.get(mid) == v) return mid;

            if(arr.get(mid) > v) return binarySearch(arr,l,mid-1, v);

            return binarySearch(arr, mid + 1, r, v);

        }
        return -1;
    }
}
