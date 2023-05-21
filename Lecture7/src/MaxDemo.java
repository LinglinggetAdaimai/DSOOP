import java.util.function.BiFunction;

interface HasIsLargerThan<T> {
    boolean isLargerThan(T that);
}


public class MaxDemo {
    // write maxValue that take in a generic array T
    // return the largest value in the array

    // first method
    // use user-provided comparator design (ex1)
    // it should be like
    // static<T> T maxValue(T[] items, BiFunction<...> isLarger)
    // where you will fill in the ...
    static <T> T maxValue(T[] items, BiFunction<T, T, Boolean > isLarger) {
        if (items.length == 0) {return null;}
        T biggest = items[0];
        for ( int i = 1; i < items.length; i++) {
            if (isLarger.apply(items[i], biggest)){
                biggest = items[i];
            }
        }
        return biggest;
    }

    // second method
    // use the default comparator design (ex2)
    // it should be like
    // static <T extends ...> T maxValue(T[] items)
    static <T extends HasIsLargerThan<T>> T maxValue(T[] items){
        if (items.length == 0) {return null;}
        T biggest = items[0];
        for ( int i = 1; i < items.length; i++) {
            if (items[i].isLargerThan(biggest)){
                biggest = items[i];
            }
        }
        return biggest;
    }

    public static void main(String[] args) {
        Cat[] friends = {
                new Cat("Cat 1", 10),
                new Cat("Cat 2", 5)
        };
        System.out.println(maxValue(friends, Lecture7::largerByWeight));
//        int maxDex = maxValue(friends, (Cat x, Cat y) -> x.w > y.w);
    }
}
