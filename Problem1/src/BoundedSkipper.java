import java.util.Iterator;

public class BoundedSkipper implements Iterable<Integer>{

    int k, n;
    public BoundedSkipper(int k, int n) {
        this.k = k;
        this.n = n;
    }

    private class BoundedSkipperIter implements Iterator<Integer> {

        int number = 1;
        int amt = 0;

        @Override
        public boolean hasNext() {
            return (amt < n );
            // T T T
            // F T F
            // TT
        }

        @Override
        public Integer next() {
            int returnval = number;
            // check if we have reached the amount of n numbers
            int y = (int) number;
            while (hasNext()) {
                while (!(String.valueOf(number).contains(String.valueOf(k)) || y%k ==0)) {
                    amt++;
                    returnval = number;
                    number++;
                    return returnval;
                }
                break;
            }
            number++;
            return next();
        }
    }
    @Override
    public Iterator<Integer> iterator() {
        return new BoundedSkipperIter();
    }

    public static void main(String[] args) {
        for (int v: new BoundedSkipper(3, 11)) {
            System.out.println(v); // prints out the above sequence on separate lines
        }
    }

}
