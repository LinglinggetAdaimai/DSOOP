//interface IntUnaryFun {
//    int apply(int x);
//}
//class IncrFun implements IntUnaryFun {
//    private int delta;
//    public IncrFun(int d) { delta = d; }
//    public IncrFun() { this(1); }
//    public int apply(int x) {
//        return x + delta;
//    }
//}
//
//public class Lecture7 {
//    static int twice(IntUnaryFun f, int x) {
//        return f.apply(f.apply(x));
//    }
//
//    public static void main(String[] args) {
//        IntUnaryFun f = new IncrFun(3);
//        IntUnaryFun g = new IncrFun();
//        System.out.println(twice(f, 2)); // ==> ?
//        System.out.println(twice(g, 9)); // ==> ?
//    }
//
//}

import java.util.function.BiFunction;
class Cat {
    String name;
    int w;
    Cat(String name, int w) { this.name = name; this.w = w;}
}
public class Lecture7 {
//    public static void main(String[] args) {
//        Cat[] friends = {
//                new Cat("Cat 1", 10),
//                new Cat("Cat 2", 5)
//        };
//        System.out.println(maxIndex(friends, Lecture7::largerByWeight));
//        int maxDex = maxIndex(friends,
//                (Cat x, Cat y) -> x.w > y.w);
//    }

    static boolean largerByWeight(Cat x, Cat y) {
        return x.w > y.w;
    }

//    static <T> int maxIndex(T[] items,
//                            BiFunction<T, T, Boolean> isLarger) {
//        if (items.length == 0) return -1;
//        int maxDex = 0; // current max index
//        for (int index = 0; index < items.length; index++) {
////            if (items[index] > items[maxDex])
//            if (isLarger.apply(items[index], items[maxDex]))
//                maxDex = index;
//        }
//        return maxDex;
//    }
}
