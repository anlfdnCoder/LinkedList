package LinkedList;

public class Node {
    public int number;
    public Node next;

    public Node previous;

    public Node(int sayi) {
        this.number = sayi;
        this.next = null; // we create object but not with parameter
        this.previous=null;
    }


}
