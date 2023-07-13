import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Decor {
    public static BinaryTreeNode mkTreeHelper(List<Integer> postOrder, Map<Integer, Integer> inOrderMap,
                                              int startPO, int endPO, int startIO, int length){
        if (length == 0) return null;
        if (length == 1) return new BinaryTreeNode(postOrder.get(startPO)); //O(1)
        else {
            int root = postOrder.get(endPO), rootIndex = inOrderMap.get(root); // O(1)
            int leftSize = rootIndex-startIO , rightSize = (length - leftSize - 1);

            BinaryTreeNode left =  mkTreeHelper(postOrder, inOrderMap, startPO, rootIndex-1, startIO, leftSize); //T(n)
            BinaryTreeNode right =  mkTreeHelper(postOrder, inOrderMap, startPO+leftSize, endPO-1, rootIndex+1, rightSize); //T(n)
            return new BinaryTreeNode(left, root, right);
        }
    }

    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder){
        // use map because the helper will ask for the index of the root everytime it runs,
        // so this saves a bit of time ig
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inOrder.size(); i++){
            inOrderMap.put(inOrder.get(i), i); // O(n)
        }
        return mkTreeHelper(postOrder, inOrderMap,0, postOrder.size()-1,0, postOrder.size()-1);
    }

}
