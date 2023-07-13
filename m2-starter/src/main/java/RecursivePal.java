public class RecursivePal<T> {
    // hint: don't forget .equals vs. ==
    public boolean isRecursivePalindrome(T[] a) {
    return isRecurHelper(a, 0, a.length-1);

    }
    public boolean isRecurHelper (T[] k, int start, int end){
        int len = end - start, mid = (start + end) / 2;
        if (len <= 3) {
            return (k[start].equals(k[end]));
        }
        else {
            if (len%2 != 0){
                boolean left = isRecurHelper(k, start, mid);
                if (left) return isRecurHelper(k, mid+1, end);
            }
            else {
                boolean left = isRecurHelper(k, start, mid-1);
                if (left) return isRecurHelper(k, mid+1,end);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] a0 = {1, 1, 5, 1, 1,};
        Integer[] a1 = {7, 8, 7, 7, 8, 7};
        Integer[] a2 = {2, 0, 4, 0, 2};
        Integer[] a3 = {7, 4, 5, 5, 4, 7, 9, 7, 4, 5, 5, 4, 7};

        System.out.println(new RecursivePal<>().isRecursivePalindrome(a0)); // expect: true
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a1)); // true
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a2)); // false
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a3)); // false
    }
}
