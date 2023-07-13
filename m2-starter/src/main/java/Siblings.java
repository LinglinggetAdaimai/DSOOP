import java.util.*;

public class Siblings {
  // add your class variable here
  // e.g. int magic;  and set the value in the constructor

  List<Integer> p = new ArrayList<>();
  public Siblings(HashMap<Integer, Integer> cpTree) {
    for (int i = 0; i < cpTree.size(); i++){
      p.add(i, cpTree.get(i));
    }
  }
  int root(int x) { // O(log n)
    if (p.get(x) != x)
      return 1 + root(p.get(x));
    return 1;
  }

  public boolean isSibling(int u, int v) {
    return root(u) == root(v);
  }

  public static void main(String[] args) {
    HashMap<Integer, Integer> tr = new HashMap<>();
    Integer[] par   = {4, 4, 4, 4, 3, 3, 8, 8, 8};
    Integer[] nodes = {4, 1, 3, 8, 0, 2, 6, 7, 5};
    for (int i=0;i<par.length;i++) tr.put(nodes[i], par[i]);

    Siblings sbl = new Siblings(tr);
    System.out.println(sbl.isSibling(2, 5)); // true
    System.out.println(sbl.isSibling(1, 7)); // false
  }
  
}
