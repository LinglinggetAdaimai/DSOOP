
public class SLList {
    private class IntNode {
        int value; // an int data item
        IntNode next; // ref to the next node

        public IntNode(int val, IntNode r) {
            this.value = val; this.next = r;
        }
    }
    int size;

    private IntNode first;

    public SLList() { first = null; }


    public void addFirst(int x) {
        first = new IntNode(x, first);
        size++;
    }

    public int getFirst() throws IndexOutOfBoundsException {
        if (first == null){
            throw new IndexOutOfBoundsException("out of range");
        }
       else return first.value;
    }

    public int get(int index) {
        IntNode currnode = first;
        int i = 0;
        if (index > size-1) {
            throw new IndexOutOfBoundsException();
        }
        while (currnode != null){
            if (i == index) {
                break;
            }
        }
        return currnode.value;
    }

}