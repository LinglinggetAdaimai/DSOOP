// Start: 15:50

package histogram;

import java.util.Iterator;

public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {


    // constructs an empty histogram (with no information)
    public SimpleHistogram() {}

    // constructs a histogram from a list of items given by the parameter items
    public SimpleHistogram(DT items[]) {}

    // constructs a (new) histogram from an existing histogram, sharing nothing internally
    public SimpleHistogram(Histogram<DT> hist) {}

    public String toString() {
        return null;
    }

    // check if the elements are the same
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        if (o == this) return true;

        MyArrayList other = (MyArrayList) o;

        if(size != other.size()){
            return false;
        }
        for(int i = 0; i < size; i++){
            if(items[i] != other.items[i]){
                return false;
            }
        }
        return true;

    }

    // Histogram Implementations
    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public int getCount(DT item) {
        return 0;
    }

    @Override
    public void setCount(DT item, int count) {

    }

    @Override
    public Iterator<DT> iterator() {
        return null;
    }
}

