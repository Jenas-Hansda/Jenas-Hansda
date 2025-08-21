package Top_Interview_150.Linked_List;



class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // 1. Interleave cloned nodes with original nodes
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // 2. Assign random pointers to cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3. Separate the original and cloned list
        curr = head;
        Node newHead = head.next;
        Node copyCurr = newHead;

        while (curr != null) {
            curr.next = copyCurr.next;
            curr = curr.next;
            if (curr != null) {
                copyCurr.next = curr.next;
                copyCurr = copyCurr.next;
            }
        }

        return newHead;
    }
}