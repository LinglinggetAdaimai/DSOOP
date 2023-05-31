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
        public boolean hasNext() { return (amt < n );}

        @Override
        public Integer next() {
                while ((String.valueOf(number).contains(String.valueOf(k)) | number%k ==0)) {
                    number++;
                }
            amt++;
            return number++;
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
