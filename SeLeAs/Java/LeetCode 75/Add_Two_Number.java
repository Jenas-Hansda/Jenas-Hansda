// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    // Constructor to create a node with value
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Add_Two_Number {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;   // The result linked list's head
        ListNode temp = null;   // Temporary pointer to build the list
        int carry = 0;          // Carry over from the previous digit

        // Traverse both lists until all nodes are processed and carry is zero
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            int sum = val1 + val2 + carry;

            // Create a new node with the digit value (sum % 10)
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;  // Update the carry for the next iteration

            // If the result list is empty, set the head and temp to the new node
            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;  // Link the new node to the current list
                temp = temp.next;     // Move the temp pointer to the new node
            }

            // Move to the next nodes in the input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the head of the resulting linked list
        return head;
    }

    // Utility method to print the linked list (for testing purposes)
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Add_Two_Number solution = new Add_Two_Number();

        // Create the first linked list: 2 -> 4 -> 3 (represents 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create the second linked list: 5 -> 6 -> 4 (represents 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Add the two numbers and get the result linked list
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the resulting linked list (expect 7 -> 0 -> 8 which represents 807)
        solution.printList(result);
    }
}
