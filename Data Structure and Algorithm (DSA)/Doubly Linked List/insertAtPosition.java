import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Insert at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
    }

    // Insert node at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        // If inserting at the beginning (position 1)
        if (position == 1) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return;
        }

        // Traverse to the (position-1)th node
        Node current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // If position is invalid
        if (current == null) {
            System.out.println("Invalid position. Nothing to insert.");
            return;
        }

        // Insert in the middle or at the end
        newNode.next = current.next;
        newNode.prev = current;

        // If it's not the last node, adjust the next node's previous pointer
        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;
        System.out.println("Inserting node with value: " + data + " at position " + position);
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert elements into the list
        System.out.print("How many elements do you want to insert initially? ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter value " + i + ": ");
            int value = scanner.nextInt();
            list.insertAtEnd(value);
        }

        // Display the current list
        System.out.println("\nCurrent Doubly Linked List:");
        list.display();

        // Ask user for the position and value to insert
        System.out.print("\nEnter the position (1-based) to insert: ");
        int position = scanner.nextInt();

        System.out.print("Enter the value to insert: ");
        int valueToInsert = scanner.nextInt();

        // Insert the node at the specified position
        list.insertAtPosition(valueToInsert, position);

        // Display the list after insertion
        System.out.println("\nDoubly Linked List after insertion:");
        list.display();

        scanner.close();
    }
}
