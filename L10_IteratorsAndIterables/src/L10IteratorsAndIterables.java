import java.util.*;

class ArraySet<T> implements Iterable<T>{
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
        private int whereAmI;
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
    public static void main(String[] args) {
//        Set<Integer> hs = new HashSet<>();
//        hs.add(5);
//        hs.add(11);
//        for (Integer e: hs) {
//            System.out.println(e);
//        }

        ArraySet<Integer> as = new ArraySet<>();
        as.add(5);
        as.add(11);
        Iterator<Integer> it = as.iterator();

        while (it.hasNext()){
            Integer e = it.next();
            System.out.println(e);
        }
        for (Integer e: as){
            System.out.println(e);
        }
    }

}
