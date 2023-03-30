package LinkedList;

public class Liste {
    public Node head;
    public Node tail;

    public Liste() {
        this.head = null;
        this.tail = null; // we create object but not with parameter
    }

    public boolean isFull() { // one of them (head and tail) is enough for isFull-Method
        if (head != null) {
            return true;
        } else {
            return false;
        }
    }

    public void addAtFirstiIndex(int number) {
        Node newElement = new Node(number);
        if (isFull()) {
            newElement.next = this.head;
            this.head = newElement;

        } else {
            this.head = newElement;
            this.tail = newElement;
        }
    }

    public void addAtLastIndex(int number) {
        Node newElement = new Node(number);

        if (isFull()) {
            this.tail.next = newElement;
            newElement = this.tail;
        } else {
            this.head = newElement;
            this.tail = newElement;
        }
    }

    public void addAtMiddleofTheList(Node newElement, int anyNumberinTheList) {
        Node flag = this.head;
        Node nextFlag = this.head.next;
        if (isFull()) {
            if (this.head == this.tail) { // only one element in the list
                this.head.next = newElement;
                this.tail = newElement;
            } else {                         // more than 1 element
                while (flag != null && nextFlag != null) {
                    if (flag.number == anyNumberinTheList) {
                        flag.next = newElement;
                        newElement.next = nextFlag;
                        break;
                    } else {
                        flag = flag.next;
                        nextFlag = nextFlag.next;
                    }
                }
                if (flag == this.tail) {
                    flag.next = newElement;
                    this.tail = newElement;
                }
            }
        } else {
            this.head = newElement;
            this.tail = newElement;
        }
    }

    public void addInTheAnyIndexNumber(Node newElement, int indexNumber) {
        Node flag = this.head;
        Node nextFlag = this.head.next;

        int count = 0;

        if (isFull()) {
            if (this.head == this.tail && indexNumber == 0) {// one element , and index is 0
                newElement.next = this.head;
                newElement = this.head.previous;
                this.head = newElement;
            } else { // more then one element
                while (flag != null && nextFlag != null) {
                    if (count == indexNumber) {
                        if (flag.previous != null) {
                            flag.previous = newElement.previous;
                            newElement.next = flag;
                            break;
                        } else {
                            newElement.next = flag;
                            this.head = newElement;
                            break;
                        }
                    } else {
                        flag = flag.next;// keep going
                        nextFlag = nextFlag.next; // keep going
                    }
                }
                if (flag == this.tail) { // addNode in the last index.
                    flag.next = newElement;
                    this.tail = newElement;
                }
            }
        } else {// first time there is no Node in the list.
            this.head = newElement;
            this.tail = newElement;
        }

    }

    public void removeFirstElement() {
        Node flag = this.head.next;
        if (!isFull()) {
            System.out.println("There is nothing to remove in the list");
        } else {
            if (this.head == this.tail) {
                this.head = null;
                System.out.println("There is no element now in the list.");
            } else {
                this.head.next = null;
                this.head = flag;// this.head = this.head.next

            }
        }
    }

    public void removeLastElement() {
        Node flag2 = this.head;
        Node flag1 = null;
        if (!isFull()) {
            System.out.println("There is nothing to remove in the list");
        } else {
            if (this.head == this.tail) {
                this.head = null;
                System.out.println("There is no element now in the list.");
            } else {
                while (flag2.next!=null){
                    flag1 = flag2;
                    flag2 = flag2.next;
                }
                if (flag2 == this.tail){
                    flag1.next = null; // connection is broken
                    this.tail = flag1;// flag1 is tail now.
                }

            }
        }
    }
    public void removeIndex(int indexNumber){
        int count = 0;
        Node flag1 = null;
        Node flag2 = this.head;
        Node flag3 = this.head.next;

        if (!isFull()){
            System.out.println("There is nothing to remove in the list");
        }else {
            while (flag2.next!=null){
                if (count == indexNumber){
                    if (indexNumber==0){
                        flag2.next = null;
                        this.head = flag3;
                    }else {
                        flag1.next = null;
                        flag2.next = null;
                        flag1.next = flag3;
                    }
                }else { //When it is count != indexNumber , keep going
                    flag1 = flag2;
                    flag2 = flag3;
                    flag3 = flag3.next;
                    count++;
                }
            }if (flag2==this.tail){
                flag1.next=null;
                flag1 = this.tail;
            }
        }
    }
    public void removeNumberInTheList(int removeNumber){
        Node flag1 = null;
        Node flag2 = this.head;
        Node flag3 = this.head.next;

        if (!isFull()){
            System.out.println("There is nothing to remove in the list");
        }else {
            if (this.head == this.tail && this.head.number == removeNumber){
                this.head = null;
                this.tail = null;
                System.out.println("There is no element now in the list.");
            }else {
                while (flag2!=null){
                    if (flag2.number == removeNumber){
                        if (flag2 == this.head){ // index number = 0 of removeElement
                            this.head = flag3;
                            flag2.next = null;
                        }else {
                            flag2.next = null;
                            flag1.next = flag3;
                        }
                        break;
                    }else {
                        flag1 = flag2;
                        flag2 = flag3;
                        flag3 = flag3.next;
                    }
                }if (flag2==this.tail){
                    flag1.next = null;
                    this.tail = flag1;
                }
            }


        }
    }


        public void show () {
            Node flag = this.head;
            int count = 0;
            while (flag != null) {
                System.out.print(flag.number + ",");
                flag = flag.next;
                count++;
            }
            System.out.println();
            if (count > 1) {
                System.out.println("There are " + count + " times elements.");
            } else if (count == 1) {
                System.out.println("There is " + count + " element.");
            } else if (count == 0) {
                System.out.println("There is no element");
            }

        }
    }

