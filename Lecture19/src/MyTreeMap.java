class TreeNode<T, V> {
    T key;
    V value;
    TreeNode<T,V> left, right;

    public TreeNode(TreeNode<T,V> left, T key, V value, TreeNode<T,V> right) {
        this.left = left; this.key = key; this.value = value; this.right = right;
    }
}

public class MyTreeMap<K extends Comparable<? super K>, V> {
    // implements the following methods by keeping a binary search tree ordered by the keys
    TreeNode<K,V> root;
    TreeNode<K, V> currRoot;

    public V get(K k){
        return getHelper(root,k);
    }
    public V getHelper(TreeNode<K, V> root, K k){
        if (root == null) return null;
        if (k.compareTo(root.key) == 0) return root.value;
        if (k.compareTo(root.key) > 0) return getHelper(root.right, k);
        if (k.compareTo(root.key) < 0) return getHelper(root.left, k);
        return root.value;
    }

    public void put(K k, V v){
        currRoot = root;
        if (currRoot == null){
            root = new TreeNode<>(null, k, v, null);
            return;}
        else if (k.compareTo(currRoot.key) < 0) {
            while (currRoot.left != null) {
                currRoot = currRoot.left;
            }
        }
        else if (k.compareTo(root.key) > 0) {
            while (currRoot.right!= null) {
                currRoot = currRoot.right;
            }
        }
        if (k.compareTo(currRoot.key) > 0) currRoot.right = new TreeNode<>(null, k, v,null);
        else currRoot.left = new TreeNode<>(null, k, v,null);
    }

    public K lowerKey(K k){
        if (root == null) return null;
        if (k.compareTo(root.key) == 0) return root.left.key;
        if (k.compareTo(root.key) < 0) {
            while (root.left != null && k.compareTo(root.right.key) != 0) {
                root = root.left;
            }
        }
        if (k.compareTo(root.key) > 0) {
            while (root.left != null && k.compareTo(root.left.key) != 0) {
                root = root.left;
            }
        }
        return root.key;
    }

    public static void main(String[] args) {
        MyTreeMap<Integer, String> treeMap = new MyTreeMap<>();

        // Insert key-value pairs into the tree
        treeMap.put(5, "Apple");
        treeMap.put(2, "Banana");
        treeMap.put(8, "Orange");
        treeMap.put(1, "Grape");
        treeMap.put(7, "Mango");

        // Retrieve values based on keys
        String fruit1 = treeMap.get(2);
        System.out.println("Value for key 2: " + fruit1); // Output: Value for key 2: Banana

        String fruit2 = treeMap.get(7);
        System.out.println("Value for key 7: " + fruit2);

        String fruit3 = treeMap.get(3);
        System.out.println("Value for key 3: " + fruit3); // Output: Value for key 7: Mango

        // Get lower key for a given key
        Integer lowerKey = treeMap.lowerKey(5);
        System.out.println("Lower key for key 5: " + lowerKey); // Output: Lower key for key 5: 2
    }
}