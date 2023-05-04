class Pair {
    int min;
    int max;
}
public class divideandcon {
     
     
        public static Pair getMinMax(int arr[], int low, int high) {
            Pair result = new Pair();
            Pair left = new Pair();
            Pair right = new Pair();
     
            // if there is only one element
            if (low == high) {
                result.max = arr[low];
                result.min = arr[low];
                return result;
            }
     
            // if there are two elements
            if (high == low + 1) {
                if (arr[low] > arr[high]) {
                    result.max = arr[low];
                    result.min = arr[high];
                } else {
                    result.max = arr[high];
                    result.min = arr[low];
                }
                return result;
            }
     
            // if there are more than 2 elements
            int mid = (low + high) / 2;
            left = getMinMax(arr, low, mid);
            right = getMinMax(arr, mid + 1, high);
     
            if (left.min < right.min)
                result.min = left.min;
            else
                result.min = right.min;
     
            if (left.max > right.max)
                result.max = left.max;
            else
                result.max = right.max;
     
            return result;
        }
    
}
