package week2;

import edu.princeton.cs.algs4.*;
public class UFClient2 {
    public static Boolean fullConnected(UF uf, int N) {
        int j = 0;
        for (int i = 1; i < N; i++)
            if (!uf.connected(j, i)) {
                return false;
            }
        return true;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        boolean check = false;
        int n = 0;
        while (!StdIn.isEmpty() && !check) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                n++;
            }
            if (fullConnected(uf, N)) {
                System.out.println(n);
                check = true;
                break;
            }
            if(StdIn.isEmpty() && !check) System.out.println("FAILED");
        }
    }
}