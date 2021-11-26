package week11;

import java.util.*;

public class missingNumbers {
    public static void getDifferrnce(List<Integer> res, List<Integer> x, List<Integer> y) {
        int n = x.size();
        int idx = 0;
        for(int i = 0; i < n; i++,idx++){
            if(x.get(i) != y.get(idx)) {
                res.add(y.get(idx));
                i--;
            }
        }
    }
    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        int sizea = arr.size();
        int sizeb = brr.size();
        List<Integer> res = new ArrayList<>();
        List<Integer>[] a1 = new List[101];
        List<Integer>[] b1 = new List[101];
        for(int i=0; i< sizea; i++) {
            a1[arr.get(i)%100].add(arr.get(i));
        }
        for(int i=0; i< sizeb; i++) {
            b1[brr.get(i)%100].add(brr.get(i));
        }
        for(int i=0; i< 101; i++) {
            if(a1[i].size() != b1[i].size())
                getDifferrnce(res, a1[i], b1[i]);
        }
        Collections.sort(res);
        return res;
    }

    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        Collections.sort(arr);
        Collections.sort(brr);
        getDifferrnce(res,arr,brr);
        return res;
    }
    static void counting (Map<Integer, Integer> mapa, List<Integer> arr) {
        for(int i=0; i<arr.size(); i++) {
            if(mapa.containsKey(arr.get(i))) {
                mapa.put(arr.get(i), mapa.get(arr.get(i)) + 1);
            } else {
                mapa.put(arr.get(i), 0);
            }
        }
    }
    public static List<Integer> missingNumbers3(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> mapa= new HashMap<>();
        Map<Integer, Integer> mapb= new HashMap<>();
        counting(mapa, arr);
        counting(mapb, brr);
        for(int i : mapb.values()) {
            int num;
            if(mapa.containsKey(i)) {
                num = mapb.get(i)-mapa.get(i);
            } else {
                num = mapb.get(i);
            }
            for(int j = 0; j< num; j++){
                res.add(i);
            }
        }
        return res;
    }

}
