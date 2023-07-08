import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPriorityQueue<T> implements IPriorityQueue<T> {
    private List<T> queueItems;
    CompareWith <T> comparefunc;
    private int size;


    public MyPriorityQueue(CompareWith<T> cc) {
        queueItems = new ArrayList<>();
        comparefunc = cc;
        size = 0;
    }

    @Override
    public void add(T item) {
        if (size == 0) {
            queueItems.add(0, item);
        }
        else {
            for (int i = 0; i < size; i++) {
                if (islessThan(item, queueItems.get(i))) {
                    queueItems.add(i, item);
                    break;
                }
            }
        }
        size++;
    }


    public boolean islessThan(T a, T b){
        return comparefunc.lessThan(a,b);
    }

    @Override
    public void addAll(List<T> items) {
        for (T element: items) {
            add(element);
        }
    }

    @Override
    public T getMinimum() {
        return queueItems.get(0);
    }

    @Override
    public void removeMinimum() {
        queueItems.remove(0);
        size--;

    }

    @Override
    public int size() {
        return size;
    }

    class MyPriorityQueueIter implements Iterator<T> {

        int start, index;
        public MyPriorityQueueIter(int start) {
            this.start = start;
            if (IsReverse()) {
                index = start-1;
            }
            else index = start;
        }
        @Override
        public boolean hasNext() {
            if (IsReverse()) {
                return index > -1;
            }
            return index < size;
        }

        @Override
        public T next() {
            if (IsReverse()) {
                return queueItems.get(index--);
            }
            return queueItems.get(index++);
        }

        private boolean IsReverse() { return start > 0;}
    }
    @Override
    public Iterator<T> iterator() {
        return new MyPriorityQueueIter(0);
    }

    @Override
    public Iterator<T> revIterator() {
        return new MyPriorityQueueIter(size);
    }
}
