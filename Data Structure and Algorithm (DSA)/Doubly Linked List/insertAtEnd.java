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

    // Insert node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // If the list is empty, new node becomes the head
        if (head == null) {
            head = newNode;
            System.out.println("Inserting node with value: " + data + " at the end.");
            return;
        }

        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Link the new node at the end
        current.next = newNode;
        newNode.prev = current;
        System.out.println("Inserting node with value: " + data + " at the end.");
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
            list.insertAtEnd(value);  // Insert at the end
        }

        // Display the current list
        System.out.println("\nCurrent Doubly Linked List:");
        list.display();

        scanner.close();
    }
}
