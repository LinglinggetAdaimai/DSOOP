import java.util.ArrayList;
import java.util.List;

public class L9InductiveThinking {
    List<Integer> change(int n ){
        // base case(s)
        switch(n){
            case 24: return List.of(5,5,7,7);// List.of is immutable
            case 25: return List.of(5,5,5,5,5);
            case 26: return List.of(7,7,7,5);
            case 27: return List.of(5,5,5,5,7);
            case 28: return List.of(7,7,7,7);
            default:
                List<Integer> sol = new ArrayList<>(change(n-5));
                sol.add(5);
                return sol;
        }
    }

    double pow (double b, int w){ // call itself around w times
        // base case
        if (w == 0) return 1;
        else {
            // Recursive/ Inductive case
            return pow(b,w-1) *b;
        }
    }
    double betterPow (double b, int w){ // call itself around w times
        if (w == 0) { return 1; }
            else {
                double t = betterPow(b,w/2); // we'll have to call this twice
                                                // so may as well store it in one var and just multiply it
                if (w%2 == 0){ // if it's even
                    return t*t;
                }
                else
                    return t*t*b;
            }
    }

    long factHelper(int n, long a) {
        if (n == 0) return a;
        else return factHelper(n-1, a*n);
    }
    long fact(int n) {return factHelper(n,1);}


}
