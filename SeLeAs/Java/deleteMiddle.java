public class deleteMiddle {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Method to delete the middle node
    public static ListNode DeleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1, 
                         new ListNode(2, 
                         new ListNode(3, 
                         new ListNode(4, 
                         new ListNode(5)))));

        System.out.print("Original list: ");
        printList(head);

        head = DeleteMiddle(head);

        System.out.print("After deleting middle node: ");
        printList(head);
    }
}
