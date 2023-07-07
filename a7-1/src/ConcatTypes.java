import java.util.LinkedList;

public class ConcatTypes {
    public static String concatPreOrder(BinaryTreeNode tree){
        if (tree!= null) {
            StringBuilder treeInfo = new StringBuilder();
            treeInfo.append(visit(tree));
            treeInfo.append(concatPreOrder(tree.left));
            treeInfo.append(concatPreOrder(tree.right));
            return treeInfo.toString();
        }
        return "";
    }

    public static String concatInOrder(BinaryTreeNode tree){
        if (tree!= null) {
            StringBuilder treeInfo = new StringBuilder();
            treeInfo.append(concatInOrder(tree.left));
            treeInfo.append(visit(tree));
            treeInfo.append(concatInOrder(tree.right));
            return treeInfo.toString();
        }
        return "";
    }
    public static String concatPostOrder(BinaryTreeNode tree){
        if (tree!= null) {
            StringBuilder treeInfo = new StringBuilder();
            treeInfo.append(concatPostOrder(tree.left));
            treeInfo.append(concatPostOrder(tree.right));
            treeInfo.append(visit(tree));
            return treeInfo.toString();
        }
        return "";
    }

    public static String visit(BinaryTreeNode node){
        if (node!= null) {
            return node.key+" ";
        }
        return null;
    }
    public static int countRight(BinaryTreeNode root){
        return  (root == null)?0:1 + countRight(root.right);
    }
    public static int countleft(BinaryTreeNode root){
        return  (root == null)?0:1 + Math.max(countleft(root.left), countleft(root.right));
    }

}
