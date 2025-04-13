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

    // Insert at end to build initial list
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

    // ✅ Delete node at a specific position (1-based index)
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Delete head node
        if (position == 1) {
            System.out.println("Deleting node with value: " + head.data);
            head = head.next;
            return;
        }

        Node current = head;
        int count = 1;

        // Traverse to the node before the one to delete
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // Check if the position is valid
        if (current == null || current.next == null) {
            System.out.println("Invalid position. No node deleted.");
        } else {
            System.out.println("Deleting node with value: " + current.next.data);
            current.next = current.next.next;
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

        System.out.println("\nCurrent Linked List:");
        list.display();

        System.out.print("\nEnter position of node to delete: ");
        int position = scanner.nextInt();

        list.deleteAtPosition(position);

        System.out.println("\nLinked List after deletion:");
        list.display();

        scanner.close();
    }
}
