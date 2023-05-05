public class SLList {
    // Singly Lnked list
    private static class IntNode {
    
        int head;
        IntNode next;
    
        public IntNode(int head, IntNode next) { 
            this.head = head; 
            this.next = next; 
        }
    }

    private IntNode sen; // the starting node
    private int size; // private so people don't mess with them


    // constructor
    public SLList() {
        sen  = new IntNode(-1, null); // who cares what number will this be so we set it to -1
    }

    // since we have the sentinol so we can add the actual first node by using the addFirst function
    public SLList(int x) {
        sen  = new IntNode(-1, new IntNode(x, null));
    }
    
    // add first
    public void addFirst(int x) {
        // new node
        sen.next = new IntNode(x, sen.next);
        size++;
        
    }
    
    public void addLast (int x) {
        
        IntNode curr = sen;
        
        while( curr.next != null) {
            curr = curr.next;
        }
        curr.next = new IntNode(x, null);
        size++;
    }

    // getFirst
    public int getFirst() {
        return sen.head;
    }

    public int getLast() {
        IntNode curr = sen;

        while(curr.next != null) {
            curr = curr.next;
        }
        return curr.head;
    }
    
    public int size() {
        return size;
    }

    public String toString() {
        // return something that can be looked at
        IntNode curr = sen.next;
        String result = "";

        while (curr.next != null) {
            result += Integer.toString(curr.head) + ", ";
            curr = curr.next;
        }

        // add the last number from the list and then return!
        return  result += Integer.toString(curr.head);

    }

    public void removeFirst() {
        // remove the first one from the list
        // please take care of the size too
        if (sen.next == null) {
            return;
        }
        sen.next = sen.next.next;
        size--;
    }

    public void insert(int newValue, int k) {
        
        // if k is at the start
        if (k == 0) {
            this.addFirst(newValue);
            return;
        }
        
        // if k is more than the size of this list
        if (k > (size-1)) {
            this.addLast(newValue);
            return;
        }
        
        // else
        IntNode curr = sen.next;
        int index = 0;
        while (index != (k-1)) {
            curr = curr.next;
            index++;
        }
        curr.next = new IntNode(newValue, curr.next);
        size++;
    }

}

