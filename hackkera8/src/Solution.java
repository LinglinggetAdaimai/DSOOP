import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right;
    public Node(int freq, char da, Node left, Node right) {
        frequency = freq;
        data = da;
        this.left = left;
        this.right = right;
    }
    public Node(int freq, Node left, Node right) {
        frequency = freq;
        this.left = left;
        this.right = right;
    }
    public Node(int freq, char dat) {
        frequency = freq;
        data = dat;
    }    public
    Node(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}
public class Solution {

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        String test = input.next();
        String test = "ABACA";
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        // build tree
        Node tree = new Node(5,
                new Node(2,new
                        Node(1,'B'),new Node(1,'C')),new Node(3,'A'));

        // print out results
        String s = "1001011";
        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s, tree);

    }
}