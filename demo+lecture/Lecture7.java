interface IntUnaryFun {
    int apply(int x);
}
class IncrFun implements IntUnaryFun {
    private int delta;
    public IncrFun(int d) { delta = d; }
    public IncrFun() { this(1); }
    public int apply(int x) {
        return x + delta;
    }
}

class DoubleFun implements IntUnaryFun {
    public int apply (int x) { return 2*x;}
}

static int twice (IntUnaryFun f, int x) {
    return f.apply(f.apply(x));
}


public class Lecture7 {
    // return where the largeest number be
    static int maxIndex(int[] items) {

        if (items.length == 0) {
            return -1;
        }
        else {
            int maxDex = 0; // current max index
            for (int i = 1; i < items.length; i++) {
                if (items [i] > items[maxDex]) {
                    maxDex = i;
                }
            }
            return maxDex;
        }
    }

    // I'd like this code to use with any type

    // High-order Comparison Function
        //


    static <T> maxIndex(T[] items) {
        if (items.length == 0) {
            return -1;
        }

    }

    public static void main(String[] args) {
        twice(new IncreFun(), 5);
    static < T extends Hasis <T> > int maxInx(int x) { // only type that can use with hasis can go into this maxInx function
        // to satisfy the hasis we'll put
           // class cat "implements Hasis<Cat>"
            // and also implement the function that is Hasis in Cat as well, since the interface is like a contract
        }
    }
}
