import java.util.Comparator;

public class MyPriorityQueue<T> {
    private T[] arrOfNode = (T[]) new Object[4];
    Comparator<T> cmp;
    int size;

    public MyPriorityQueue(Comparator<T> cc) {
        cmp = cc;
        size = 0;
    }

    public void add(T node){
        // add obj to the last index
        // swim, or swapping the number untill it's at somewhere it belongs

        if (size == 0) {
            arrOfNode[1] = node;
            size++;
            return;
        }
        if (size+1 == arrOfNode.length){
            grow();
        }
        // add the element at the bottom aka last index
        arrOfNode[++size] = node;
        swim(size);
    }

    public T findMax(){
        return arrOfNode[1];
    }

    public void removeMax(){
        // put the last number to the first
        // sink until the children are smaller than prt
        if (size == 1) {
            arrOfNode[1] = null;
            return;
        }
        arrOfNode[1] = arrOfNode[size];
        arrOfNode[size--] = null;
        sink(1);
    }

    private void swim(int index){
        // check if child larger than parent if yes then swap and swim until it has reached the top
        int parent = index/2, child = index;
        if (child > 1 && cmp.compare(arrOfNode[child], arrOfNode[parent]) >= 0){
            swap(child, parent);
            swim(parent);
        }
    }

    public void sink(int index){
        // find the max and swap curr to that child, then sink
        int parent = index, L_child = (2*index) + 1, R_child = (2*index) + 2;
        int max = parent;
        // find max in the local triangle
        if (L_child < size
                && cmp.compare(arrOfNode[L_child], arrOfNode[max]) > 0) max = L_child;
        if (R_child < size
                && cmp.compare(arrOfNode[R_child], arrOfNode[max]) > 0) max = R_child;

        if (max != parent) {// if the max isn't the parent then swap and sink
            swap(parent, max);
            sink(max);
        }
    }

    public void swap(int index, int changeToindex){
        T temp = arrOfNode[changeToindex];
        arrOfNode[changeToindex] = arrOfNode[index];
        arrOfNode[index] = temp;
    }

    public void grow() {
        // make a new array of the newCap
        T[] newArrOfNode = (T[]) new Object[size*2+1];
        // copy thing over
        System.arraycopy(arrOfNode, 0, newArrOfNode, 0, size+1);
        // point the item
        arrOfNode = newArrOfNode;
    }

}
