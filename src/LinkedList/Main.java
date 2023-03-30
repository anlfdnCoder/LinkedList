package LinkedList;

public class Main {
    public static void main(String[] args) {
        Liste liste = new Liste();

        liste.addAtFirstiIndex(5);
        liste.addAtLastIndex(10);
        liste.addAtFirstiIndex(20);

        liste.addAtMiddleofTheList(new Node(30),20);
        liste.addAtMiddleofTheList(new Node(8),5);
        liste.addInTheAnyIndexNumber(new Node(3),0);

        liste.removeFirstElement();
        liste.removeFirstElement();
        liste.removeLastElement();

        liste.addAtLastIndex(15);
        liste.addAtFirstiIndex(10);

        liste.removeIndex(3);
        liste.addAtFirstiIndex(99);

        liste.removeNumberInTheList(5);


        liste.show();

    }
}
