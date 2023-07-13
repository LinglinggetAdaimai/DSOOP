public class Decoding {

    // which children we'll visit
    // check if it's null or not
        // yes then do nothing
        // no then print out and reset
    void decode(String s, Node root) {
        Node currNode = root;
        int length = s.length(), index = 0;

        for (int i = 0; i <length; i++) {
            int edge = (int) s.charAt(index++);
            if (edge == 49) {
                currNode = currNode.right;
            }
            if (edge == 48) {
                currNode = currNode.left;
            }
            if (currNode.data != 0){
                System.out.print(currNode.data);
                currNode = root;
            }
        }
    }

}
