public class Last {
    public static Integer binarySearchLast(int[] a, int k){
        return searchLastHelper(a, 0, a.length, k);
    }

    public static Integer searchLastHelper(int[] a, int start, int end, int k) {
        int len = end - start;
        if (len == 0) return null;
        if (len == 1) {
            if (a[start] != k) return null;
            else return start;
        } else {
            int half = start + len / 2;
            if (a[half] == k && a[half + 1] != k) return half;
            if (a[half] > k) return searchLastHelper(a, start, half, k); // left
            else return searchLastHelper(a, half + 1, end, k);
        }
    }
}

