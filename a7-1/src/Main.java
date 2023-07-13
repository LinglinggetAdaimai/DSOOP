import java.util.*;

import static java.util.List.*;

public class Main {

    /**
     * Uproot main
     */
//    public static void main(String[] args) {
//    Uproot up = new Uproot();
//    MakeTree makeTree = new MakeTree();
//    int[] k1 = new int[] {1,2,3,4,5,6,7,8};
//    BinaryTreeNode treek1 = makeTree.buildBST(k1);
//        System.out.println(ConcatTypes.concatPreOrder(treek1));
////        System.out.println(ConcatTypes.concatInOrder(treek1));
////        System.out.println(ConcatTypes.concatPostOrder(treek1));
//
//        HashMap<Integer,Integer> treetoPar1 = Uproot.treeToParentMap(treek1);
////        for (Map.Entry<Integer, Integer> entry : treetoPar1.entrySet()) {
////            Integer key = entry.getKey();
////            Integer value = entry.getValue();
////            System.out.println("child: " + key + ", parent: " + value);
////        }
//        BinaryTreeNode partoTree1 = Uproot.parentMapToTree(treetoPar1);
//        System.out.println(ConcatTypes.concatPreOrder(partoTree1));
//    }

    /**
     * MultiMergeSort main
     */

//
//    public static void main(String[] args) {
//        LinkedList<Integer> LL1 = new LinkedList<>();
//        LL1.addAll(List.of(9, 10, 11, 13, 17));
//
//        LinkedList<Integer> LL2 = new LinkedList<>();
//        LL2.addAll(List.of(1, 2, 5));
//
//        LinkedList<Integer> LL3 = new LinkedList<>();
//
//        LinkedList<Integer> LL4 = new LinkedList<>();
//        LL4.addAll(List.of(0));
//
//        LinkedList<Integer> LL5 = new LinkedList<>();
//        LL5.addAll(List.of(3, 7));
//
//        int arraysize = 5;
//
//        LinkedList<Integer>[] lists = (LinkedList<Integer>[]) new LinkedList<?>[arraysize];
//
//        lists[0] = LL1;
//        lists[1] = LL2;
//        lists[2] = LL3;
//        lists[3] = LL4;
//        lists[4] = LL5;
//        LinkedList<Integer> returnlist = MultiwayMerge.mergeAll(lists);
//        int size = returnlist.size(), i = 0;
//        while (i < size) {
//            System.out.println(returnlist.get(i++));
//        }
//    }
//        Uproot upro = new Uproot();
//        System.out.println("DEBUG ");
//        System.out.println("======================= ");
//        long startTime = System.currentTimeMillis();
//
//
//        int n = 2000;
//        // Test map to tree.
//        System.out.println("Map to tree:");
//        Map<Integer, Integer> p = new HashMap<>();
//        for (int i = 0; i < n - 1; i++) {
//            p.put(i, i + 1);
//        }
//
//        for (Integer key : p.keySet())
//            System.out.println(String.format("(%d, %d)", key, p.get(key)));
//        BinaryTreeNode a = upro.parentMapToTree(p);
//
//        System.out.println(ConcatTypes.concatPreOrder(a));
//        System.out.println();
//
//        // Test tree to map.
//        System.out.println("Tree to map:");
//        System.out.println(ConcatTypes.concatPreOrder(a));
//        p = Uproot.treeToParentMap(a);
//        for (Integer key : p.keySet())
//            System.out.println(String.format("(%d, %d)", key, p.get(key)));
//
//        long endTime = System.currentTimeMillis();
//        float duration = (endTime - startTime) / 1000F;  //divide by 1000000 to get milliseconds.
//        System.out.println("Execution time: " + duration + " seconds.");
//    }


    /**
     * ConcatType main
     */
    public static void main(String[] args) {
//    MakeTree makeTree = new MakeTree();
//    int[] k1 = new int[] {1,2,3,4,5,6,7,8};
////    int[] k1 = new int[] {1,2,3};
//    BinaryTreeNode treek1 = makeTree.buildBST(k1);
//        System.out.print("Preorder: ");
//        System.out.println(ConcatTypes.concatPreOrder(treek1));
//        System.out.print("Inorder: ");
//        System.out.println(ConcatTypes.concatInOrder(treek1));
//        System.out.print("Postorder: ");
//        System.out.println(ConcatTypes.concatPostOrder(treek1));
//
//        LinkedList<Integer> poo = new LinkedList<>();
//        poo.addAll(List.of(2, 4, 5, 12, 10, 7));
//
//        LinkedList<Integer> inor = new LinkedList<>(List.of(2, 4, 5, 7, 10, 12));
//
//        BinaryTreeNode preoNinor = Decor.mkTree(poo,inor);
//
//        System.out.print("Preorder: ");
//        System.out.println(ConcatTypes.concatPreOrder(preoNinor));
//        System.out.print("Preorder: 7 5 4 2 10 12\n");
//        System.out.print("Inorder: ");
//        System.out.println(ConcatTypes.concatInOrder(preoNinor));
//        System.out.print("Inorder: 2 4 5 7 10 12\n");
//        System.out.print("Postorder: ");
//        System.out.println(ConcatTypes.concatPostOrder(preoNinor));
//        System.out.print("Postorder: 2 4 5 12 10 7\n");

//        LinkedList<Integer> poo = new LinkedList<>(List.of( 10, 40, 25, 60, 90, 75, 50, 125, 175, 150, 100));
//        LinkedList<Integer> inor = new LinkedList<>(List.of(10, 25, 40, 50, 60, 75, 90, 100, 125, 150, 175));
//
//        BinaryTreeNode preoNinor = Decor.mkTree(poo,inor);
//
//        System.out.print("Preorder: ");
//        System.out.println(ConcatTypes.concatPreOrder(preoNinor));
//        System.out.print("Preorder: ");
//        System.out.println("100, 50, 25, 10, 40, 75, 60, 90, 150, 125, 175");
//        System.out.print("Inorder: ");
//        System.out.println(ConcatTypes.concatInOrder(preoNinor));
//        System.out.print("Inorder:");
//        System.out.println("100, 50, 25, 10, 40, 75, 60, 90, 150, 125, 175");
//        System.out.print("Postorder: ");
//        System.out.println(ConcatTypes.concatPostOrder(preoNinor));
//        System.out.print("Postorder: ");
//        System.out.println(" 10, 40, 25, 60, 90, 75, 50, 125, 175, 150, 100");

//        LinkedList<Integer> poo = new LinkedList<>(List.of(1,2,4,3,6,8,7,5 ));
//        LinkedList<Integer> inor = new LinkedList<>(List.of(1,2,3,4,5,6,7,8));
//
//        BinaryTreeNode preoNinor = Decor.mkTree(poo,inor);
//
//
//        System.out.print("Preorder: ");
//        System.out.println(ConcatTypes.concatPreOrder(preoNinor));
//        System.out.print("Preorder: ");
//        System.out.println("5,3,2,1,4,7,6,8");
//        System.out.print("Inorder:");
//        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.INORDER));
//        System.out.print("Inorder:");
//        System.out.println("1,2,3,4,5,6,7,8");
//        System.out.print("Postorder: ");
//        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.POSTORDER));
//        System.out.print( "Postorder: ");
//        System.out.println("1,2,4,3,6,8,7,5");

        LinkedList<Integer> poo = new LinkedList<>(of( 4,5,2,1,9,12,7 ));
        LinkedList<Integer> inor = new LinkedList<>(of( 4,5,2,1,7,12,9));

        BinaryTreeNode preoNinor = Decor.mkTree(poo,inor);
//

        System.out.print("Postorder: ");
        System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.POSTORDER));

        System.out.print( "Postorder: ");
        System.out.println("4 5 2 1 9 12 7 ");
        System.out.print("Inorder:");
       System.out.println(Helpers.Debug.display(preoNinor, Helpers.Debug.TreeOrder.INORDER));
        System.out.print("Inorder:");
        System.out.println("4 5 3 2 7 12 9");
//        int[] keys = {1, 2, 3, 4, 5};
//        BinaryTreeNode bst = MakeTree.buildBST(keys);
//        System.out.println("DEBUG:");
//        System.out.println(Helpers.Debug.display(bst, Helpers.Debug.TreeOrder.INORDER));
    }
}
