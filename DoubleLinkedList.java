class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoubleLinkedList {

    static Node head = null;
    static Node tail = null;

    public static void traverseForward() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public static void traverseBackward() {
        Node current = tail;
        while(current != null) {
            System.out.println(current.data + " ");
            current = current.prev;
        }
    }

    public static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if(tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public static void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if(position == 1) {
            insertAtBeginning(data);
        } else {
            Node current = head;
            int currentPosition = 1;
            
            while(current != null && currentPosition < position) {
                current = current.next;
                currentPosition++;
            }

            if(current == null) {
                insertAtEnd(data);
            } else {
                newNode.next = current;
                newNode.prev = current.prev;
                
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
    }

    public static void deleteFirst() {
        if(head == null) {
            return;
        }

        if(head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    public static void deleteLast() {
        if(tail == null) {
            return;
        }

        if(head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    public static void deleteAtPosition(int position) {
        if(head == null) {
            return;
        }

        if(position == 1) {
            deleteFirst();
            return;
        }

        Node current = head;
        int currentPosition = 1;
        while(current != null && currentPosition < position) {
            current = current.next;
            currentPosition++;
        }

        if(current == null) {
            System.out.println("Wrong position");
            return;
        }

        if(current == tail) {
            deleteLast();
            return;
        }

        Node toDelete = current;
        toDelete.prev.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;
        toDelete.next = null;
        toDelete.prev = null;
    }

    public static void displayList(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        insertAtEnd(5);

        System.out.println("After insertion at the end");
        displayList(head);

        System.out.println();

        System.out.println("After insertion at the beginning");
        insertAtBeginning(0);
        displayList(head);

        System.out.println();

        System.out.println("After insertion at a specific position");
        insertAtPosition(6, 2);
        displayList(head);

        System.out.println();

        System.out.println("After deleting at the beginning");
        deleteFirst();
        displayList(head);

        System.out.println();

        System.out.println("After deleting at the end");
        deleteLast();
        displayList(head);

        System.out.println();

        System.out.println("After deleting at a specific position");
        deleteAtPosition(2);
        displayList(head);
    }
}