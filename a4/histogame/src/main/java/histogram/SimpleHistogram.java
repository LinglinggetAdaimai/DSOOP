// Start: 15:50

package histogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {

    private HashMap<DT, Integer> domain;

    // constructs an empty histogram (with no information)
    public SimpleHistogram() {
        domain = new HashMap<>();
    }

    // constructs a histogram from a list of items given by the parameter items
    public SimpleHistogram(DT items[]) {
        domain= new HashMap<>();
        for (DT element : items) {
            if (domain.containsKey(element)) {
                setCount(element, (getCount(element)+1));
            }
            else setCount(element, 1);
        }
    }

    // constructs a (new) histogram from an existing histogram, sharing nothing internally
    public SimpleHistogram(Histogram<DT> hist) {
       HashMap<DT, Integer> another_hist = new HashMap<>();
    }

    public boolean IsExist(DT item){
        return domain.containsKey(item);
    }

    public String toString() {

    }

    @Override
    public boolean equals(Object obj) { // TODO

    }

    // check if the elements are the same


    // Returns the total frequency count of all items in the domain combined.
    @Override
    public int getTotalCount() {
        int total = 0;
        for (Map.Entry<DT, Integer> pair : domain.entrySet()) {
            total += pair.getValue();
        }
        return total;
    }

    /** Returns the frequency count of a given domain item.
     * If invalid domainitem is given, return 0.
     * @param item: element that we want the occurrence
    */
    @Override
    public int getCount(DT item) {
        int count = IsExist(item)? domain.get(item) : 0;
        return count;
    }

    /** Sets the frequecy count of a given domain item. If the domain item
     * doesn't yet exist in the domain, this will also add it to the domain.
     * @param item: element that we want the occurrence
     * @param count: numbers of occurrence
     */
    @Override
    public void setCount(DT item, int count) {domain.put(item, count);}

    class SimpleHistogramIter implements Iterator<DT> {

        private int index;

        @Override
        public boolean hasNext() {
            return index < domain.size();
        }

        @Override
        public DT next() {
            return (DT)domain.keySet().toArray()[index++];
        }
    }

    @Override
    public Iterator<DT> iterator() {
        return domain.keySet().iterator();
    }
}

