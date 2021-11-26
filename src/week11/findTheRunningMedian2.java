package week11;

import java.util.List;
import java.util.TreeSet;

public class findTheRunningMedian2 {
    static class Node{
        int data;
        int idx;
        public Node(int data, int idx) {
            this.data = data;
            this.idx = idx;
        }
    }
    public static void runningMedian(List<Integer> a) {
        TreeSet<Node> arr = new TreeSet<>();
        for(int i = 0; i< a.size(); i++) {
            arr.add(new Node(a.get(i), i));
        }

    }
}
