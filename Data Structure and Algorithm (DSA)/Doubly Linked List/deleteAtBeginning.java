import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev; // Pointer to the previous node

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null; // Initially, prev is null
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
        newNode.prev = current; // Set the previous pointer of the new node to the last node
    }

    // Delete node at the beginning of the list
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        System.out.println("Deleting node with value: " + head.data);

        if (head.next != null) {
            head = head.next;   // Move the head to the next node
            head.prev = null;   // Set the previous pointer of the new head to null
        } else {
            head = null;  // If there's only one node, make the list empty
        }
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
        System.out.print("How many elements to insert initially? ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter value " + i + ": ");
            int value = scanner.nextInt();
            list.insertAtEnd(value);
        }

        // Display the initial list
        System.out.println("\nCurrent Doubly Linked List:");
        list.display();

        // Deleting a node at the beginning
        System.out.println("\nDeleting node at the beginning...");
        list.deleteAtBeginning();

        // Display the list after deletion
        System.out.println("\nDoubly Linked List after deletion:");
        list.display();

        scanner.close();
    }
}
