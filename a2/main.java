import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        // double[] A = {1, 12, 2, 28, 44, 75};
        double[] A = {2.5, 1.0, 9.8, 5.4, 3.3, 0.25, 4.25};

        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int n = A.length;
        double sum = (Arrays.stream(A).sum()) - A[0]- A[n-1];
        System.out.println(sum/n);

    }
}
