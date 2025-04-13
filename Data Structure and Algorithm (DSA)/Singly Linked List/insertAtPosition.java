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

    // Insert at the end (for initial list creation)
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

    // ✅ Insert at a specific position (1-based index)
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        // Insert at beginning if linked list is not Available
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        int count = 1;

        // Traverse to node before the insertion point
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds. Inserting at end.");
            insertAtEnd(data);
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Display the list
    public void display() {
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

        System.out.print("\nEnter value to insert: ");
        int newValue = scanner.nextInt();

        System.out.print("Enter position to insert at (1-based index): ");
        int position = scanner.nextInt();

        list.insertAtPosition(newValue, position);

        System.out.println("\nLinked List after insertion at position " + position + ":");
        list.display();

        scanner.close();
    }
}
