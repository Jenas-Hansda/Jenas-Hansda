class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) return null;

        Node curr = root; // Start with the root of the tree

        while (curr != null) {
            Node dummy = new Node(0); // Dummy node to build the next level
            Node tail = dummy;        // Tail tracks the end of the next level

            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next; // Move to next node in current level
            }

            // Move to the next level
            curr = dummy.next;
        }

        return root;
    }
}
