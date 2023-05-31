package histogram;

import java.util.Iterator;


public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {
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


// Also these

//    // constructs an empty histogram (with no information)
//    public SimpleHistogram()
//    // constructs a histogram from a list of items given by the parameter items
//    public SimpleHistogram(DT items[])
//    // constructs a (new) histogram from an existing histogram, sharing nothing // internally
//    public SimpleHistogram(Histogram<DT> hist)
//    public toString()
//    public equals()
}

