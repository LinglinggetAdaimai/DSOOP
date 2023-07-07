import java.util.Arrays;

public class MakeTree {
/**
 * takes in an array and spit out binary tree
 * then analyse its running time
 */

// Subtask 1: takes an array pof int keys and returns a balanced BST
    // given that n is the length of the list, your algo should run at most O(n log n)
    // and the tree is no deeper than 1 + logn -> knowing that if it's balanced then this wouldn't be our concern

    public static BinaryTreeNode buildBST(int[] keys) {
        // sort first, then put it in the binary tree
        Arrays.sort(keys);
        return toBinaryTree(keys,0, keys.length);
    }

    public static BinaryTreeNode toBinaryTree(int[] k, int start, int end){
        int len = end - start, mid = (start+end)/2;
        if (len == 1) return new BinaryTreeNode(k[start]);
        if (len == 2) return new BinaryTreeNode(new BinaryTreeNode(k[start]), k[end-1],null);
        if (len == 3) return new BinaryTreeNode(new BinaryTreeNode(k[start]), k[mid], new BinaryTreeNode(k[end-1]));
        else {
            return new BinaryTreeNode(toBinaryTree(k, start, mid), k[mid], toBinaryTree(k, mid+1, end));
        }
    }
// Subtask 2: analyse the running time --> in the latex file kub
}
