package week10;

public class IsBinarySearchTree {
    boolean checkBST(Node root) {
        if(root == null){
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
}
