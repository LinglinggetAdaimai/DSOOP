public class Pokemon {

    String name;
    int level;

    // constructor -- maybe you want something to be set when the obj. is created
    Pokemon() { 
        level = 1; // when the pokemon gets created then level will be set to 1; 
    }

    Pokemon( String name, int level) {
        this.name = name; // "this" refers to the var in this class
    
    }

    static void update(Pokemon f, int x) {
        f.level = f.level + 42;
        x = x + 42;
    }

    // method
    void attack() {
        System.out.println(name + " attacks");
    }

    public static void main(String[] args) {

        // each obj. gets its own set of variable 

        Pokemon p1 = new Pokemon();
        p1.name = "Pikachu"; // "." = dot operator
        p1.level = 10;
        
        Pokemon p2= new Pokemon();
        p2.name = "Lingling"; // "." = dot operator
        p2.level = 30;

        // after set up the Pokemon(name, level) constructor
        Pokemon p3 = new Pokemon("IDK", 100);
        
        int a = 5;
        update(p3, a);

        System.out.println(p3.level);
        System.out.println(a);
        
    }
}