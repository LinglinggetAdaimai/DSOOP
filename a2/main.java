public class main {
    public static void main(String[] args) {

        int[] A = {1, 12, 2, 28, 44, 75};
        int[] B = {2, 13, 3, 29, 45, 76};
        int[] C = {3, 14, 53, 30, 46, 77};
        int[] D = {4, 15, 54, 31, 47, 78};
        int[] E = {5, 16, 55, 32, 48, 79};
        int[] F = {6, 17, 56, 33, 49, 80};
        int[] G = {7, 18, 90, 34, 50, 81};
        int[] H = {8, 19, 9, 35, 51, 82};
        int[] I = {9, 20, 75, 36, 52, 83};
        int[] J = {10, 65, 76, 37, 53, 84};
        int[] K = {11, 2, 77, 38, 46, 85};
        int[] L = {12, 3, 78, 39, 47, 61};
        int[] M = {13, 4, 79, 13, 48, 62};
        int[] N = {14, 5, 80, 14, 49, 63};
        int[] O = {15, 6, 81, 15, 50, 64};
        int[] P = {16, 7, 82, 46, 51, 65};
        int[] Q = {17, 8, 83, 47, 52, 66};

        System.out.println(MinMax.minMaxAverage(A) == 38);
        System.out.println(MinMax.minMaxAverage(B) == 39);
        System.out.println(MinMax.minMaxAverage(C) == 40);
        System.out.println(MinMax.minMaxAverage(D) == 41);
        System.out.println(MinMax.minMaxAverage(E) == 42);
        System.out.println(MinMax.minMaxAverage(F) == 43);
        System.out.println(MinMax.minMaxAverage(G) == 48.5);
        System.out.println(MinMax.minMaxAverage(H) == 45);
        System.out.println(MinMax.minMaxAverage(I) == 46);
        System.out.println(MinMax.minMaxAverage(J) == 47);
        System.out.println(MinMax.minMaxAverage(K) == 43.5);
        System.out.println(MinMax.minMaxAverage(L) == 40.5);
        System.out.println(MinMax.minMaxAverage(M) == 41.5);
        System.out.println(MinMax.minMaxAverage(N) == 42.5);
        System.out.println(MinMax.minMaxAverage(O) == 43.5);
        System.out.println(MinMax.minMaxAverage(P) == 44.5);
        System.out.println(MinMax.minMaxAverage(Q) == 45.5);

    }
}
