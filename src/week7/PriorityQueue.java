package week7;

import edu.princeton.cs.algs4.In;
import week5.ResizingArrayQueue;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class PriorityQueue{

    private static final int INIT_CAPACITY = 8;
    private int[] q;       // queue elements
    private int n;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;


    public PriorityQueue() {
        q =  new int[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    // resize the underlying array
    private void resize(int capacity) {
        assert capacity >= n;
        int[] copy =  new int[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last  = n;
    }

    public void insert(int item) {
        // double size of array if necessary and recopy to front of array
        if (n == q.length) resize(2*q.length);   // double size of array if necessary
        q[last++] = item;                        // add item
        if (last == q.length) last = 0;          // wrap-around
        n++;
    }

    public int deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int min = q[0];
        int minI = 0;
        for(int i = first; i< last; i++) {
            if(q[i] < min) {
                min = q[i];
                minI = i;
            }
        }
        int item = q[first];
        for(int i = minI; i< last; i++) {
            q[i] = q[i+1];
        }
        q[last] = Integer.parseInt(null);
        last--;
        n--;
        if (first == q.length) first = 0;
        // shrink size of array if necessary
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public int next() {
            if (!hasNext()) throw new NoSuchElementException();
            int item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

}
