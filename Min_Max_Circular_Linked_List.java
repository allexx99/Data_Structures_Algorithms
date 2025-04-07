public class Min_Max_Circular_Linked_List {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    public void addLast(int data) {
        Node newNode = new Node(data);
        
        if(tail == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void minNode() {
        Node current = head;

        int min = head.data;

        if(head == null) {
            System.out.println("List is empty");
        } else {
            do {
                current = current.next;

                if(min > current.data) {
                    min = current.data;
                }
            } while (current != head);
        }

        System.out.println("Minimum value node in the list is: " + min);
    }

    public void maxNode() {
        Node current = head;

        int max = head.data;

        if(head == null) {
            System.out.println("List is empty");
        } else {
            do {
                current = current.next;

                if(max < current.data) {
                    max = current.data;
                }
            } while (current != head);
        }

        System.out.println("Maximum value node in the list is: " + max);
    }

    public static void displayList(Node head) {
        Node current = head;
        System.out.print(current.data + " --> ");
        Node temp = head.next;
        while(temp != head) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }

        System.out.print("NULL");
    }

    public static void main(String[] args) {
        Min_Max_Circular_Linked_List mm = new Min_Max_Circular_Linked_List();

        mm.addLast(5);
        mm.addLast(20);
        mm.addLast(10);
        mm.addLast(1);

        mm.displayList(head);

        System.out.println();

        mm.minNode();

        mm.maxNode();
    }
}