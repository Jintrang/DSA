package week8;

import edu.princeton.cs.algs4.StdIn;

import java.util.*;
import java.util.Scanner;
public class findTheRunningMedian {
    static void runningMedian(List<Integer> a) {
        // Write your code here
        int N = a.size();
        List<Double> list = new ArrayList<>();
        if(N == 1) {
            System.out.println(String.format("%.1f", a.get(0)));
        } else if(N==2) {
            System.out.println(String.format("%.1f", ((float)(a.get(0)+ a.get(1))) / 2));
        } else {
            Queue <Integer> maxPQ = new PriorityQueue(N/2 + 1, Collections.reverseOrder());
            Queue <Integer> minPQ = new PriorityQueue(N/2 + 1);
            maxPQ.add(Math.max(a.get(0), a.get(1)));
            minPQ.add(Math.min(a.get(0), a.get(1)));
            System.out.println(String.format("%.1f", a.get(0)));
            System.out.println(String.format("%.1f", ((float)(a.get(0)+ a.get(1))) / 2));
            for(int i = 2; i < N; i++) {
                if(a.get(i) > maxPQ.size()) maxPQ.add(a.get(i));
                else minPQ.add(a.get(i));
                if(maxPQ.size() > minPQ.size()) minPQ.add(maxPQ.poll());
                else if(minPQ.size() > maxPQ.size()) maxPQ.add(minPQ.poll());
                if(maxPQ.size() == maxPQ.size()) {
                    System.out.println(String.format("%.1f", ((float)(maxPQ.peek()+ minPQ.peek())) / 2));
                } else if (maxPQ.size() > minPQ.size())
                    System.out.println(String.format("%.1f", (float)maxPQ.peek()));
                else
                    System.out.println(String.format("%.1f", (float)minPQ.peek()));
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i< 10; i++) {
            int abc = StdIn.readInt();
            System.out.println(i);
            arr.add(abc);
        }
        runningMedian(arr);
    }
}
