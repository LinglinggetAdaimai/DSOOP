import java.util.ArrayList;

public class AllCaps {
    // find the Capital letter
    // return the set of the index
    // you'll encounter some other letter too
    // allCapLocations("a@bAaCt99q") == {3, 5}

    public static int[] allCapLocations(String st) {

        ArrayList<Integer> listofindex = new ArrayList<>();
        int amtindex = 0;

        for (int i = 0; i < st.length(); i++) {
            if( (st.charAt(i) >= 'A' && st.charAt(i) <= 'Z')){
                listofindex.add(i);
                amtindex++;
            }
        }

        int[] list = new int[amtindex];

        for (int i = 0; i < amtindex; i++) {
            list[i] = listofindex.get(i);
        }

        return list;
    }


}
