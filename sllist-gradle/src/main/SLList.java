public class SLList {
    private class IntNode {
        int value; // an int data item
        IntNode next; // ref to the next node

        public IntNode(int val, IntNode r) {
            this.value = val; this.next = r;
        }
    }

    private IntNode first;

    public SLList() { first = null; }


    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        try {
            return first.value;
        }
        catch (IndexOutOfBoundsException e) {

        }
    }

    // implement get() return the element at the position index
    public int get() {
        return first.value;
    }

    // if the list is empty, getfirst() will throw an outofbound exception
    // so do the get() function

    // write tests to ensure all the methods work correctly as intended.
    // it should be throughly exercise various combination of list usage.
    // your test should verify that the correct exception is thrown at the right moment as well
}