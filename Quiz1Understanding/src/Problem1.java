class Feline {int w = 1;}

class Up {
    void update (int x, String y, int[] z, Integer a, Feline f){
        x = 1; y = "ping"; z[1] = 3; a =23; f.w = 5; f = new Feline();
    }
}

public class Problem1 {



    public static void main(String[] args) {
        int x = 10; String y = "pong"; int[] z = {4, 0, 6};
        Integer a = 55; Feline f = new Feline();

        Up toupdate = new Up();


        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(a);
        System.out.println(f);

        toupdate.update(x, y, z, a, f);

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(a);
        System.out.println(f);

    }
}
