public class SLList_wosen {
    
    private static class IntNode {
    
        int head;
        IntNode next;
    
        public IntNode(int head, IntNode next) { 
            this.head = head; 
            this.next = next; 
        }
    }


    private IntNode start; // the starting node
    private int size; // private so people don't mess with them


    // constructor
    public SLList_wosen() {
        start = null;
    }

    // getFirst
    public int getFirst() {
        return start.head;
    }

    public int size() {
        return size;
    }

    // add first
    public void addFirst(int x) {
        // everything on the right hand side gets run first
        start = new IntNode(x, start);
        size++;
        
    }
    
    // public void addLast (int x) {
    //     IntNode temp = end;
    //     end.next = new IntNode(x,null);
    //     end = new IntNode(x,null);
    //     size++;
    // }
    
    public void addLast (int x) {
        IntNode p = start;

        // when the list is empty we just add another node in it
        if (p == null) {
            addFirst(x);
            return;
        }
        while( p.next != null) {
            p = p.next;
            size++;
        }
        p.next = new IntNode(x, null);
    }

}

