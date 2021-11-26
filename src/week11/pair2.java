package week11;
import edu.princeton.cs.algs4.StdIn;
import java.util.HashSet;

public class pair2 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int k = StdIn.readInt();
        HashSet<Integer> arr = new HashSet<>();
        int count = 0;
        for(int i = 0; i< n; i++) {
            int num = StdIn.readInt();
            arr.add(num);
        }
        for(Integer key: arr) {
            if(arr.contains(key + k)) count++;
        }
        System.out.println(count);
    }
}
