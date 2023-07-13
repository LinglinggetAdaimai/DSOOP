import java.util.ArrayList;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    // FindMed
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.addAll(List.of(0, 1, 2, 4, 6, 5, 3));
//        System.out.println(FindMed.findMedian(list));
//    }
    // TreeHuff
//    public static void main(String[] args) {
////        int[][]grid =
////        [
////        [1, 1, 1, 0],
////        [0, 1, 1, 0],
////        [0, 0, 1, 0],
////        [1, 0, 0, 0]]
//        List<List<Integer>> list = new ArrayList<>();
//        list.add(new ArrayList<>());
//        list.add(new ArrayList<>());
//        list.add(new ArrayList<>());
//
//        list.set(0,List.of(1, 0, 0, 1, 0, 0, 1));
//        list.set(1,List.of(0, 0, 0, 0, 1, 1, 1));
//        list.set(2,List.of(1, 0, 0, 0, 0, 0, 1));
//
//
//        System.out.println(ConnectedCells.connectedCell(list));
//        }
    public static void main(String[] args) {
//        1
//        5 3
//        1 2
//        1 3
//        3 4
//        1
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        list.get(0).add(1);
        list.get(0).add(2);

        list.get(1).add(1);
        list.get(1).add(3);

        list.get(2).add(3);
        list.get(2).add(4);
//        System.out.println(BreadthFS.bfs(5,3,list,1).toString());
        System.out.println(Journey.journeyToMoon(5, list));
    }
}
