import java.util.Arrays;
    public class Unknown { 

        public static int w; 
        private static int x; 
        private int y;
        public int[] z = new int[5];


        public Unknown() {w += 1; y = w;}
        public static void setX(int i) {x += i;} public void setZ(int i) {z[y] = i; y += 1;}
        public int getW() {return w;}
        public int getX() {return x;}
        public int getY() {return y;}
        public int getZ(int i) {return z[i];}
    
    public static void main(String[] args) {
        // SLList L = new SLList();
        // L.addFirst(17);
        // L.addFirst(3);
        // int x = L.getFirst();
        // System.out.println(x);
        // int[] intnit = new int[5];
        // {"h", "el", "l", "o,W", "orld!"};
        // System.out.println(Arrays.toString(intnit));
        // int[] a = new int[3]; a[0] = 1;
        // a[1] = 3; System.out.println(a);

        System.out.println(Unknown.w); // 0
        System.out.println(Unknown.x); // 0
        System.out.println(Unknown.y); // error
        System.out.println(Arrays.toString(z)); // error


    }
}
