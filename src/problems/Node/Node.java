package problems.Node;

public class Node {
    public int[] val;
    public Node next;
    public Node back;
    public Node() {}
    public Node(int[] val) {this.val = val;}
    public Node(int[] val, Node next, Node back){
        this.val = val;
        this.next = next;
        this.back = back;
    }
}
