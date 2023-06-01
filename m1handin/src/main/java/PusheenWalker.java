import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class PusheenWalker<T> implements Iterable<T> {

    ArrayList<T> givenlist;

    // put the list into 1dArray
    public PusheenWalker(List<List<T>> tb) {
        givenlist = new ArrayList<>();
        for (List<T> outer : tb) {
            for (T item: outer) {
                givenlist.add(item);
            }
        }

    }
    private class PusheenWalkerIter implements Iterator<T>{

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < givenlist.size();
        }

        @Override
        public T next() {

            return givenlist.get(index++);
        }
    }


    public Iterator<T> iterator() {
        return new PusheenWalkerIter();
    }

}
