// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static class isEven implements Predicate<Integer> {
        @Override
        public boolean test(Integer x) {
            return x % 2 == 0;
        }
    }

    public static void main(String[] args) {
        CountIf<Integer> countEven = new CountIf<>(new isEven());
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
        System.out.println(countEven.count(numbers));
    }
}