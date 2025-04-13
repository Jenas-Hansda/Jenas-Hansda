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

    // Delete node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        Node current = head;

        // If position is 1 (delete from beginning)
        if (position == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            System.out.println("Deleting node with value: " + current.data);
            return;
        }

        // Traverse to the position
        int count = 1;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        // If position is out of bounds
        if (current == null) {
            System.out.println("Invalid position. Nothing to delete.");
            return;
        }

        // If deleting the last node
        if (current.next == null) {
            current.prev.next = null;
            System.out.println("Deleting last node with value: " + current.data);
            return;
        }

        // General case: deleting a node in the middle
        current.prev.next = current.next;
        current.next.prev = current.prev;
        System.out.println("Deleting node with value: " + current.data);
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

        // Ask user for the position to delete
        System.out.print("\nEnter the position (1-based) to delete: ");
        int position = scanner.nextInt();

        // Delete the node at the specified position
        list.deleteAtPosition(position);

        // Display the list after deletion
        System.out.println("\nDoubly Linked List after deletion:");
        list.display();

        scanner.close();
    }
}
