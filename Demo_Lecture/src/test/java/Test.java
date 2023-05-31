interface IntUnaryFun {
    int apply(int x); // class that implements this will get an int 
																						// then return int
}
class IncrFun implements IntUnaryFun {
    private int delta;
    public IncrFun(int d) { delta = d; }
    public IncrFun() { this(1); }
    public int apply(int x) {
        return x + delta;
    }
}

public class Test {
    static int twice(IntUnaryFun f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        IntUnaryFun f = new IncrFun(3);
        IntUnaryFun g = new IncrFun();
        System.out.println(twice(f, 2)); // ==> ?
        System.out.println(twice(g, 9)); // ==> ?
    }

}