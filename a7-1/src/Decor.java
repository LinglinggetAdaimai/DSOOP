import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Decor {
    public static BinaryTreeNode mkTreeHelper(List<Integer> postOrder, Map<Integer, Integer> inOrderMap,
                                              int startPO, int endPO, int startIO, int length){
        if (length == 0) return null;
        if (length == 1) return new BinaryTreeNode(postOrder.get(startPO));
        else {
            int root = postOrder.get(endPO), rootIndex = inOrderMap.get(root);
            int leftSize = rootIndex-startIO , rightSize = (length - leftSize - 1);

            BinaryTreeNode left =  mkTreeHelper(postOrder, inOrderMap, startPO, rootIndex-1, startIO, leftSize);
            BinaryTreeNode right =  mkTreeHelper(postOrder, inOrderMap, startPO+leftSize, endPO-1, rootIndex+1, rightSize);
            return new BinaryTreeNode(left, root, right);
        }
    }

    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder){
        // use map because the helper will ask for the index of the root everytime it runs,
        // so this saves a bit of time ig
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inOrder.size(); i++){
            inOrderMap.put(inOrder.get(i), i);
        }
        return mkTreeHelper(postOrder, inOrderMap,0, postOrder.size()-1,0, postOrder.size()-1);
    }

}
