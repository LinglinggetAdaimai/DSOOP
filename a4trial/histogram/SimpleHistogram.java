// Start: 15:50

package histogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class SimpleHistogram<DT> implements Histogram<DT> {

    private HashMap<DT, Integer> domains;

    // constructs an empty histogram (with no information)
    public SimpleHistogram() {
        domains = new HashMap<>();
    }

    // constructs a histogram from a list of items given by the parameter items
    public SimpleHistogram(DT items[]) {
        domains = new HashMap<>();
        for (DT element : items) {
            if (domains.containsKey(element)) {
                setCount(element, (getCount(element)+1));
            }
            else setCount(element, 1);
        }
    }

    // constructs a (new) histogram from an existing histogram, sharing nothing internally
    public SimpleHistogram(Histogram<DT> hist) {
        domains = new HashMap<>();
        for (DT currEle : hist) {
            domains.put(currEle, hist.getCount(currEle));
        }
    }

    public int getValue (DT key) {
        if (domains.get(key) == null) {
            return 0;
        }
        return domains.get(key);
    }

    public boolean IsExist(DT item){
        return domains.containsKey(item);
    }


    // Returns the total frequency count of all items in the domain combined.
    @Override
    public int getTotalCount() {
        int total = 0;
        for (Map.Entry<DT, Integer> pair : domains.entrySet()) {
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
        int count = IsExist(item)? domains.get(item) : 0;
        return count;
    }

    /** Sets the frequecy count of a given domain item. If the domain item
     * doesn't yet exist in the domain, this will also add it to the domain.
     * @param item: element that we want the occurrence
     * @param count: numbers of occurrence
     */
    @Override
    public void setCount(DT item, int count) {
        domains.put(item, count);}

    public String toString() {

        StringBuilder returnstr = new StringBuilder();
        for (DT key: this.domains.keySet()) {
            returnstr.append("key: ");
            returnstr.append(key);
            returnstr.append(" value: "+ this.domains.get(key)+ '\n');
        }

        return returnstr.toString();

    }

    // In this regard, two histograms a and b are equal
    // if they have the exact same domain values and the frequency of each item is identical in both histograms.
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {return false;}
        SimpleHistogram<DT> o = (SimpleHistogram<DT>) obj;
        if(this.domains.size() != o.domains.size()) {return false;}
        for (DT key: o.domains.keySet()) {
            if(o.domains.get(key) != this.domains.get(key)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<DT> iterator() {
        return this.domains.keySet().iterator();
    }
}

