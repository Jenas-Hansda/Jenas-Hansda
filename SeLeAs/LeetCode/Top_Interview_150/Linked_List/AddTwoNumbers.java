package Top_Interview_150.Linked_List;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int carry = 0;

        // Traverse both lists until there are no nodes left and carry is zero
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            int val = val1 + val2 + carry;

            // Create a new node with the digit value
            ListNode newNode = new ListNode(val % 10);
            carry = val / 10; // Update the carry

            // If the result list is empty, set the head and temp to the new node
            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode; // Link the new node to the current list
                temp = temp.next; // Move the temp pointer
            }

            // Move to the next nodes in the input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the head of the resulting linked list
        return head;

    }
}