import java.util.ArrayList;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int bottle = 16;

        for (int i = 1; i <= bottle; i++) {
            double n = i + 1;
            double base = 2;
//            System.out.println( i + " " + (int) (Math.log(n)/ Math.log(base)) );
            System.out.println( i + " " + (int) (n/4 ));
        }
    }
}