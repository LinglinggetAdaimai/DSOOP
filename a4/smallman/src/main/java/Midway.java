public class Midway {

    // adjusted from solve_hanoi
    public static long stepsRemainingHelper(int[] diskPos, int index, int from_peg, int to_peg, int aux_peg) {
        if (index < 0) return 0; // moved every disk already

        if (diskPos[index] != to_peg) { // currIndex isn't at the final peg
            return (long) Math.pow(2, index) + stepsRemainingHelper(diskPos, index - 1, from_peg, aux_peg, to_peg);
        } else {
            return stepsRemainingHelper(diskPos, index - 1, aux_peg, to_peg, from_peg); // yes then go to the next index
        }
    }

    public static long stepsRemaining(int[] diskPos) {
        int n = diskPos.length;
        return stepsRemainingHelper(diskPos, n-1, 0, 1, 2);
    }
    public static void main(String args[]) { // Test case
        int[] array1 = {0};
        int[] array2 = {2, 2, 1};
        int[] array3 = {2, 2, 1, 1, 2, 2, 1};
        int[] array4 = {2, 2, 0};
        int[] array5 = {1, 2, 0};
        System.out.println(stepsRemaining(array1));// should return 1
        System.out.println(stepsRemaining(array2));// should return 3
        System.out.println(stepsRemaining(array3));// should return 51
        System.out.println(stepsRemaining(array4));// should return 4
        System.out.println(stepsRemaining(array5));// should return 5
    }

}
