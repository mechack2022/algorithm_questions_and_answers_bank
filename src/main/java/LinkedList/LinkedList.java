package LinkedList;

class LinkedList<T> {  // Generic LinkedList class
    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void insert(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void displayList() {
        Node current = head;
        if (head == null) {
            System.out.println("The given list is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " -> ");  // Print data instead of object reference
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList<Integer> newList = new LinkedList<Integer>();  // Use Integer type for LinkedList

        // Adding data to the list by calling the insert function
        newList.insert(10);
        newList.insert(30);
        newList.insert(50);
        newList.insert(70);
        newList.insert(100);
        // Displaying the data in the list by calling displayList() function
        newList.displayList();
    }
}
