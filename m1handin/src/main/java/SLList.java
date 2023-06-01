import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;

public class SLList<T> {
    // an inner storage node class
    private class Node {
        T head;
        Node next;
        Node(T head, Node next) {
            this.head = head;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public SLList() { sentinel = new Node(null, null); size = 0; }
    public SLList(List<T> existing) {
        this();
        Node p = sentinel;
        for (T elt: existing) {
            p.next = new Node(elt, null);
            p = p.next; size++;

        }
    }

    // return the first item of the list
    public T getFirst() {
        return sentinel.next.head;
    }

    public void addFirst(T val) { 
        sentinel.next = new Node(val, sentinel.next); 
        size++; 
    }

    public T[] toArray() {
        Node currNode = sentinel.next;

        T[] returnArray = (T[]) new Object[size];
        int index = 0;

        while (currNode != null) {
            returnArray[index] = currNode.head;
            index++;
            currNode = currNode.next;
        }
        return returnArray;
    }


    public void deleteIf(Predicate<T> p) {
        Node currNode = sentinel;
        // starts from the sentinel
        // check the next one
            // if true
                // check if the next one of the one we check is null
                    // if yes then assign the currnext to null
                    // if not then we assign to next next

    while (currNode.next != null) {
            if(p.test(currNode.next.head)) {
                size--;
                if (currNode.next.next == null) {
                    currNode.next = null;
                }
                else {currNode.next = currNode.next.next;}
            }
            currNode = currNode.next;
        }
        // check the last node
        if(p.test(currNode.head)){
            currNode.head = null;
//            size --; // cannot reduce the size
        }
    }

    public SLList<T> reversed() {
        SLList <T> returnList = new SLList<>();
        Node currNode = sentinel.next;

        // iterate through the list and add to the front of the new list
        while (currNode != null) {
                returnList.addFirst(currNode.head);
                currNode = currNode.next;
            }
        return returnList;
    }



    public int size() { return size; }

    static class BanA implements Predicate<String> {
        public boolean test(String t) { return t.equals("a"); }
    }

    public static void main(String[] args) {
        SLList<String> list1 = new SLList<>(List.of("J", "a", "v", "a", "S", "E"));
        SLList<String> list2 = new SLList<>(List.of("J", "a", "v", "a", "S", "E"));

        System.out.println(Arrays.toString(list1.toArray()));    // should print [J, a, v, a, S, E] //

        list1.deleteIf((String e) -> e.equals(e.toUpperCase()));
        System.out.println(Arrays.toString(list1.toArray()));
        // list1 should become [a, v, a]
        list2.deleteIf(new BanA());
        System.out.println(Arrays.toString(list2.toArray()));
        // list2 should become [J, v, S, E]
        SLList<String> list3 = list2.reversed();
        System.out.println(Arrays.toString(list3.toArray()));
        // list3 is  [E, S, v, J]
    }
}
