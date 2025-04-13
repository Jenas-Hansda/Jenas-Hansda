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

    // Delete node at the end of the list
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // If there's only one node
        if (head.next == null) {
            System.out.println("Deleting last node with value: " + head.data);
            head = null;
            return;
        }

        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // current is now the last node
        System.out.println("Deleting last node with value: " + current.data);

        // Set the second to last node's next pointer to null
        current.prev.next = null;
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

        // Ask user if they want to delete the node at the end
        System.out.print("\nDo you want to delete the last node? (yes/no): ");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("yes")) {
            list.deleteAtEnd();
        }

        // Display the list after deletion
        System.out.println("\nDoubly Linked List after deletion:");
        list.display();

        scanner.close();
    }
}
