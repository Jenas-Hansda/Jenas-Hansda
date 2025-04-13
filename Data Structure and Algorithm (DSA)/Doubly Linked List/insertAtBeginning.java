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

    // Insert node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        // If the list is empty, new node becomes the head
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;   // New node's next points to the old head
            head.prev = newNode;   // Old head's prev points to the new node
            head = newNode;        // Update head to the new node
        }
        System.out.println("Inserting node with value: " + data + " at the beginning.");
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
            list.insertAtBeginning(value);  // Insert at the beginning
        }

        // Display the current list
        System.out.println("\nCurrent Doubly Linked List:");
        list.display();

        scanner.close();
    }
}
