package week9;

//import edu.princeton.cs.algs4.Queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class treeInorderTraversal {
    public static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void levelOrder(Node root) {
        Queue<Integer> xx = new ArrayDeque<>();
        xx.add(root.data);
        addroot(xx, root);
        int x = xx.size();
        for(int i = 0; i < x; i++) {
            System.out.print(xx.poll() + " ");
        }
    }

    private static void addroot(Queue<Integer> xx, Node root) {
        if(root.left != null){
            xx.add(root.left.data);
        }
        if(root.right != null){
            xx.add(root.right.data);
        }
        if(root.left != null) addroot(xx, root.left);
        if(root.right != null) addroot(xx, root.right);
    }


    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
