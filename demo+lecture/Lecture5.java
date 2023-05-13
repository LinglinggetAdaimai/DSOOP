import java.util.LinkedList;

class AList {
    private int[] items;
    private int size;

    public AList() {
        items = new int[0];
        size = 0;
    }

    // public int size() { return items.length;}
    // public int get(int i) { return items[i];}
    // public int getFirst() { return items[0];}
    // public int getLast() {return items[size()-1];}
    // public void addLast(int x) {

    //     // // create a new array and make it big enough to store the old data and new
    //     // int[] newItems = new int[size()+1];

    //     // //copy over old data
    //     // System.arraycopy(items, 0, newItems, 0, items.length);

    //     // // put in the new last item
    //     // newItems[size()] = x;

    //     // // Make items points to the new items
    //     // items = newItems;

    // }



    public int size() { return items.length;}
        public int get(int i) { return items[i];}
        public int getFirst() { return items[0];}
        public int getLast() {return items[size()-1];}
        public void removeLast() {
            items[size-1] = 0; // not-primmitive have to set the one that we removed to null
            size--;
        }

        public void grow(int newCap) {
            // make a new array of the newCap
            int[] newItems = new int[newCap];
            // copy thing over
            System.arraycopy(items, 0, newItems, 0, size);

            // point the item 
            items = newItems;

        }

        public void addLast(int x) {
            if (size == items.length) {
                grow(size*2);
            }
            items[size-1] = 0; // not-primmitive have to set the one that we removed to null
            size--;


        }
        
}

public class Lecture5 {
    
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        AList list = new AList();
        for (int k = 0; k<30_000; k++) {
            list.addLast(k);
        }

        System.out.println(list.getLast());

        long stopTime = System.nanoTime();

        System.out.printf("Took %f ms\n", (stopTime - startTime)/1e6);
    }
}
