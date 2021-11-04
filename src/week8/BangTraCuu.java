package week8;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BangTraCuu {
    public static void main(String[] args) {
        String S = StdIn.readLine();
        String [] SS = S.split(" ");
        boolean [] check = new boolean[SS.length];
        Arrays.fill(check, false);
        List<String> arr = new ArrayList<>();
        for(int i = 0; i< SS.length; i++) {
            if(!check[i]) {
                check[i] = true;
                int n = 1;
                for(int j = i +1; j < SS.length; j++) {
                    if(!check[j] && SS[i].equals(SS[j])) {
                        check[j] = true;
                        n++;
                    }
                }
                arr.add(String. valueOf(check[i]) + " " + String. valueOf(n)) ;
            }
        }
        Collections.sort(arr);
    }
}
