package Diamond;


public class Diamond {
        public static void printDiamond(int k){

        int h = k + 1;

        // print the first half
        for (int i = 1; i < h; i++) {

            // "#" holder
            String hash = "#".repeat(h-i);

            // "*" holder
            String star = "*".repeat((2*i)-1);

            // formatted printing
            System.out.printf("%s%s%s\n", hash, star, hash);

        }

        // print the second half, starting from the
        for (int i = 2; i < h; i++, k--) {

            // "#" holder
            String hash = "#".repeat(i);

            // "*" holder
            String star = "*".repeat((2*(k-1))-1);

            // formatted printing
            System.out.printf("%s%s%s\n", hash, star, hash);

        }
    }

    public static void main(String[] args) {
        printDiamond(3);
    }
}

