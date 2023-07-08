class TreeNode<T> {
    T key;
    TreeNode<T> left, right;

    public TreeNode(TreeNode<T> left, T key, TreeNode<T> right) {
        this.left = left; this.key = key; this.right = right;
    }
}
public class Lecture18 {

    public static<T> int count(TreeNode<T> root){
        return  (root == null)?0:1 + Math.max(count(root.left), count(root.right));
    }

    /**
     * that returns the concatenation of the keys in the tree visited using a pre-order traversal.
     * As an example, consider the tree below
     * tring concatenation turns out to be expensive.
     * Writing x + y takes time O(len(x) + len(y)).
     * For this problem, use StringBuilder appropriately to make sure that
     * the total running time of the method is linear in the length of the returned string.
     */
    public static String concatPreorder(TreeNode<String> tree){
        if (tree!= null) {
            StringBuilder treeInfo = new StringBuilder();
            treeInfo.append(visit(tree));
            treeInfo.append(concatPreorder(tree.left));
            treeInfo.append(concatPreorder(tree.right));
            return treeInfo.toString();
        }
        return "";
    }

    public static<T> String visit(TreeNode<T> node){
        if (node!= null) {
            StringBuilder nodeInfo = new StringBuilder();
            nodeInfo.append(node.key);
            return nodeInfo.toString();
        }
        return "";
    }
}