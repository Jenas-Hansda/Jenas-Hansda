import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Insert at end
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
    }

    // ✅ Delete node at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // If there's only one node in the list
        if (head.next == null) {
            System.out.println("Deleting last node with value: " + head.data);
            head = null;
            return;
        }

        // Traverse to the second last node
        Node current = head;
        while (current.next != null && current.next.next != null) {
            current = current.next;
        }

        System.out.println("Deleting last node with value: " + current.next.data);
        current.next = null;
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("How many elements to insert initially? ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter value " + i + ": ");
            int value = scanner.nextInt();
            list.insertAtEnd(value);
        }

        // Display the initial list
        System.out.println("\nInitial Linked List:");
        list.display();

        // Deleting a node at the end
        System.out.println("\nDeleting node from the end...");
        list.deleteAtEnd();

        // Display the list after deletion
        System.out.println("\nLinked List after deletion:");
        list.display();

        scanner.close();
    }
}
