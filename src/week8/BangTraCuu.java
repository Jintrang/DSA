package week8;

import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class BangTraCuu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String S = scan.nextLine();
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
                arr.add(String. valueOf(SS[i]) + " " + String. valueOf(n)) ;
            }
        }
        Collections.sort(arr);
        for(int i = 0; i< arr.size(); i++) {
            String [] arrr= arr.get(i).split(" ");
            System.out.println(arrr[0] + " "+ arrr[1]);
        }
    }
}
