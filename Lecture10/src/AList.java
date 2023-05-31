import java.util.Iterator;

public class AList<T> implements Iterable<T> {
    public T[] items;
    private int size;
    public AList() {
        items = (T[]) new Object[8];
        size = 0;
    }
    public void addFirst(T x) {

        if (size == items.length) {
            grow(size*2);
        }

        T[] newItems = (T[]) new Object[items.length];
        System.arraycopy(items,0, newItems,1,size);
        newItems[0] = x;


        items = newItems;
        size++;

    }



    public void grow(int newCap) {
        // make a new array of the newCap
        T[] newItems = (T[]) new Object[newCap];
        // copy thing over
        System.arraycopy(items, 0, newItems, 0, size);

        // point the item
        items = newItems;

    }

    public void addLast (T x) {

        if (size == items.length) {
            grow(size*2);
        }

        size++;
        items[size-1] = x;

    }

    public T get(int i ){ return items[i];}

    public T getFirst() { return items[0];}

    public int size() {return size;}

    public T getLast() {return items[size()-1];}



    public void removeLast(){
        items[size-1] = null; // not-primmitive have to set the one that we removed to null
        size--;
    }

    public void removeFirst() {
        for (int i = 0; i < size ; i++) {
            items[i] = items[i+1];
        }
        size--;
    }

    public void insert(T newValue, int k) {
        if (k >= size) {
            return;
        }
        if (size() == items.length) {
            grow(size*2);
        }
        for(int i = k+1; i < size ; i++) {
            items[i] = items[i-1];
        }
        items[k] = newValue;
    }

    public String toString () {
        String result = "";
        for (int i = 0; i < size()-1; i++) {
            result += items[i].toString() + ",";
        }
        return  result += items[size-1].toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new AListIterator();
    }

    private class AListIterator implements Iterator<T> {

        int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return get(index++);
        }
    }

}
