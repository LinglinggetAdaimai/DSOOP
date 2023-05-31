import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class ArraySet<T> {
    private List<T> items; // keep the set in here

    public ArraySet(){items = new ArrayList<>();}
    public void add(T value){
        if (!contains(value)) {
            items.add(value);
        }
    }
    public boolean contains(T value){
        return items.contains(value);
    }
    public int size() {return items.size();}


    // let's implement the Iterator<E>
    private class ArraySetIterator implements Iterator<T> {


        // we don't put it as static because we might wanna iterate from another end as well
        // so, we set it to private :)
        private int whereAmI; // : index

        public ArraySetIterator() {whereAmI = 0;}

        @Override
        public boolean hasNext() {
            return whereAmI < items.size();
        }

        @Override
        public T next() {
            T toReturn = items.get(whereAmI); // similar to item[whereAmI] because Java doesn't allow you to use bracket notation for array list
            whereAmI++;
            return toReturn;
            // return items.get(whereAmI++); boom! C thing, love
        }
    }
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }
}
public class L10IteratorsAndIterables {
//    public static void main(String[] args) {
//        ArraySet<Integer> as = new ArraySet<>();
//        as.add(5);
//        as.add(11);
//        Iterator<Integer> it = as.iterator();
//        for (int v: new ArraySet() {
//            System.out.println(v); // prints out the above sequence on separate lines
//    }
}