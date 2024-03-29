package week9;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i<t; i++) {
            String res = pair_left[i] + " " + pair_right[i];
            hs.add(res);
            System.out.println(hs.size());
        }
        //Write your code here

    }
}
