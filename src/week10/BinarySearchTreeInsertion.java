package week10;

import java.util.*;
import java.io.*;

/*class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class BinarySearchTreeInsertion {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node insert(Node root,int data) {
        if(root == null) {
            Node x = new Node(data);
            x.data = data;
            return x;
        } else if(root.data > data) //value should go on left
        {
            if(root.left == null)
            {
                Node left = new Node(data);
                left.data = data;
                root.left = left;
            }
            else //keep looking, strictly on left as value is smaller than root
            {
                insert(root.left, data);
            }

        }
        else //value should go on right (or equal to root, but i believe this is guaranteed to not be in input data)
        {
            if(root.right == null) //place for value found
            {
                Node right = new Node(data);
                right.data = data;
                root.right = right;
            }
            else //keep looking, strictly to right of root as the value is greater
            {
                insert(root.right, data);
            }
        }
        return root;

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
        preOrder(root);
    }
}
