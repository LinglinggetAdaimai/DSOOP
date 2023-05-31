public class CountIf<T> {
    // the storing part

    Predicate<T> pred;
    public CountIf(Predicate <T> pred) {
        this.pred = pred;

    }

    // counting from the output that give out from the predicate
    public int count(T[] items) {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if(pred.test(items[i])){
                count++;
            }
        }
        return count;
    }
}
