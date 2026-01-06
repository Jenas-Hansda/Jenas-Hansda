class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 1;
        int currLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                resultLevel = currLevel;
            }

            currLevel++;
        }

        return resultLevel;
    }
}
