
class IntNode {
    // instance variables

    IntNode (int head, IntNode next) {
        this.head = head;
        this.next = next;
    }

    int head;
    IntNode next;
    
    public String toString() {
        if (this.next == null) {
            return Integer.toString(this.head);
        }
        else {
            return Integer.toString(this.head) + ", " +this.next.toString();
        }
    }
}

public class Lecture3 {
    
    public static void main(String[] args) {
        int 

    }

    
}
