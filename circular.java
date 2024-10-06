class CircularLinkedList {

    // Node definition
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    private Node head = null;
    private Node tail = null;

    // Function to add a node to the circular linked list
    public void add(int data) {
        Node newNode = new Node(data);

        // If the list is empty, initialize the head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;  // Point the new node to itself, circular structure
        } else {
            tail.next = newNode;  // Add new node after the current tail
            tail = newNode;       // Update tail to the new node
            tail.next = head;     // Link the last node to the head to maintain the circular structure
        }
    }

    // Function to display the circular linked list
    public void display() {
        Node current = head;

        if (head != null) {
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);  // Stop when we come back to the head
            System.out.println();
        } else {
            System.out.println("The list is empty.");
        }
    }

    // Function to delete a node from the circular linked list
    public void delete(int value) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        Node previous = null;

        // If the list contains only one node
        if (head.data == value && head.next == head) {
            head = null;
            tail = null;
            return;
        }

        // If the node to be deleted is the head node
        if (head.data == value) {
            tail.next = head.next;  // Update tail to point to the new head
            head = head.next;       // Update head to the next node
            return;
        }

        // Traverse the list to find the node to be deleted
        do {
            previous = current;
            current = current.next;
            if (current.data == value) {
                previous.next = current.next;  // Bypass the node to delete it
                if (current == tail) {         // If the node is the tail, update tail
                    tail = previous;
                }
                return;
            }
        } while (current != head);
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Adding nodes to the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Display the circular linked list
        System.out.println("Circular Linked List: ");
        list.display();  // Output: 1 2 3 4

        // Deleting a node from the list
        list.delete(3);
        System.out.println("After deleting node 3: ");
        list.display();  // Output: 1 2 4
    }
}
