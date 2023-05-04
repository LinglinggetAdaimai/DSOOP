public class IntNode {

    int head;
    IntNode next;

    public IntNode(int head, IntNode next) { 
        this.head = head; 
        this.next = next; 
    }

    public String iterativeToString () {
        // implement this
        IntNode currNode = this;
        String result = "";

        // stop before the last one so the format is beautiful
        while (currNode.next != null) {
            result += Integer.toString(currNode.head) + ", ";
            currNode = currNode.next;    
        }

        // add the last number from the list and then return!
        return  result += Integer.toString(currNode.head);
    }


    public int get(int i) {
        // Implement this
        int index = 0;
        IntNode currNode = this;

        // loop untill index is the same as i
        while (index != i) {

            currNode = currNode.next;
            index++;
        }

        // return the value
        return currNode.head;


    }
    
    
    public void set(int i, int newValue) {
        // Implement this
        int index = 0;
        IntNode currNode = this;


        while (index != i) {
            currNode = currNode.next;
            index++;
        }

        // set it to new value
        currNode.head = newValue;
    }


    public IntNode incrList(int delta) {
        if (this.next == null)
            return new IntNode(this.head + delta, null);
        else 
            return new IntNode(this.head +delta, this.next.incrList(delta)); // return new nodew that link to the 
    }
    
}
