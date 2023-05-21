import java.util.ArrayList;
import java.util.List;

class Animal {
    void walk() { System.out.println("walking");}
    void eat( String what) {System.out.println("eating" + what);}
}

class Pet extends Animal {
    void play(String with) {System.out.println("playing with " + with);}
}
public class Lecture6 {


    public static void main(String[] args) {
        // List<Integer> l = new List<>(); 
        ConstFive cc = new ConstFive();
        IncrByTwo ii = new IncrByTwo();

        Series c = cc;
        
        // c.foo(10) - doesn't work

        Series[] arr = {cc,ii};
        
    
    }

    
}
