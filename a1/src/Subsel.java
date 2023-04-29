package Subsel;
public class Subsel {

    public static int[] takeEvery(int[] a, int stride, int beginWith) {

        // find the size of the result array
        int n = 0;

        // condition: after incresing the n, we wont get result that is more than the lenght of the arr and it's not less than 0
        // while under this conditon, increment "i"
        while( (n*stride)+beginWith < a.length && (n*stride)+beginWith >= 0){
            n++;
        }

        //init array size according to above
        int[] result = new int[n];
    
        // replace the new arr with element from the old arr(a) which specify by the b + (s * multiply)
        // until multiply is == size of the new arr
        for (int multiply = 0; multiply < n ; multiply++) {
            result [multiply] = a[(multiply*stride) + beginWith];
        }

        return result;
    }


    public static int[] takeEvery(int[] a, int stride) {

        // since it technically starts at the beginning bc no specificaiton
        return takeEvery(a, stride, 0);

    }

}
