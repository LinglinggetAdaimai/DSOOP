// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        public static void main(String[] args)
        {
            String t1 = "Breakfast";
            String t2 = "Breakfast";
            String t4 = "Pig";
            String t5 = "hey";

            String t3 = new String("hey");

     
            System.out.printf("Brek == Brek? %s\n", t1 == t2?"true":"false");
            System.out.printf("Brek == Peppa? %s\n", t2 == t4?"true":"false");
            System.out.printf("Brek == hey? %s\n", t1 == t5?"true":"false");
            System.out.printf("Pig == hey? %s\n", t4 == t5?"true":"false");
            System.out.printf("hey == hey(new)? %s\n", t5 == t3?"true":"false");
            
        
            System.out.println(t1.equals(t2));
            System.out.println(t2.equals(t4));
            System.out.println(t1.equals(t5));
            System.out.println(t4.equals(t5));
        }
}