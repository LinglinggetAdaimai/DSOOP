import java.util.*;
class JustForFun<Integer> {
    private Map<Integer, Set<Integer>> map = new HashMap<>();

    public void addOutcome(Integer outcome){ map.put(outcome, new HashSet<>());}

    public void addNum (Integer outcome, Integer num1, Integer num2){
        if (map.containsKey(outcome)){
            map.get(outcome).add(num1);
            map.get(outcome).add(num2);
        }
        else {
            addOutcome(outcome);
            addNum(outcome,num1,num2);
        }
    }
    public List<Integer> getKey(){
        Set<Integer> set =  map.keySet();
        List<Integer> list = new ArrayList<>();
            for (Integer ele :set){
                list.add(ele);
            }
        return list;
    }

}
public class KthFactor {
    public static List<Integer> kFactorization(int n, List<Integer> A) {
        return kFacHelper(n, A);
    }
    public static List<Integer> kFacHelper(int k, List<Integer> A) {
        int Alen = A.size();
        List<Integer> num = new ArrayList<>();
        JustForFun map = new JustForFun();

        for (int i = 0; i < Alen; i++) {
            if (k % A.get(i) == 0) {
                A.remove(i);
            }
        }
        Alen = A.size();
        for (int i = 0; i < Alen; i++){
            for (int j = 0; j < Alen; j++){
                int num1 = A.get(i), num2 = A.get(j);
                int outcome = num1*num2;
                if (k % (num1*num2) == 0){
                    map.addNum(outcome, num1, num2);
                }
            }
        }
        List<Integer> keyval = map.getKey();
        Collections.sort(keyval);
        return num;

    }
    public static void kthAnotherHelper (List<Integer> list, Integer left, int max){
        if (left == 1) return;


    }

}

