import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Uproot {
    public static void preAddToMap(HashMap<Integer, Integer> map, Integer parent, BinaryTreeNode child) {
        if (child != null) {
            map.put(child.key, parent);
            preAddToMap(map, child.key, child.left);
            preAddToMap(map, child.key, child.right);
        }
    }

// Subtask 1: Takes in Binary Tree and return parent mapping (done)
    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T){
        HashMap<Integer, Integer> returnMap = new HashMap<>();
        preAddToMap(returnMap, T.key,T);
        returnMap.remove(T.key);
        return returnMap;
    }

// Subtask 2: Takes in parent mapping and return Binary Tree


    public static void addNodeToNode(Map<Integer, BinaryTreeNode> linkedmap, Integer currKey, Integer currPar){
        BinaryTreeNode currNode;
        if (linkedmap.containsKey(currKey)) currNode = linkedmap.get(currKey);
        else currNode = new BinaryTreeNode(currKey);

        if (linkedmap.get(currPar).left == null) linkedmap.get(currPar).left = currNode; // I wanna change this to recursion that give you the binaryTreeNode}
        else linkedmap.get(currPar).right = currNode;
        linkedmap.put(currKey, currNode);
    }

    public static BinaryTreeNode preMakeTree (Map<Integer, BinaryTreeNode> linkedmap, Map<Integer, Integer> map) {//, Integer key, Integer keyPar){
        BinaryTreeNode root = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer currKey = entry.getKey(), currPar = entry.getValue();
            if (!linkedmap.containsKey(currPar)) linkedmap.put(currPar, new BinaryTreeNode(currPar));
            addNodeToNode(linkedmap, currKey,currPar);

            // find root to return
            if (!(map.containsKey(currPar))){
                root = linkedmap.get(currPar);
            }
        }
        return root;
    }
    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map){
        Map<Integer, BinaryTreeNode> linkedMap = new HashMap<>();
        return preMakeTree(linkedMap, map);
    }
}
