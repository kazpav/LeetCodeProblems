
class Solution {
    public int kthSmallest(TreeNode root, int k) {
       //        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
//        int i = 0;
        while (!stack.isEmpty()) {
            TreeNode stackTopElement = stack.pop();
//            i++;
            k--;
            if (0 == k)
                return stackTopElement.val;

            TreeNode r = stackTopElement.right;
            while (r != null) {
                stack.push(r);
                r = r.left;
            }

        }

        return -1;



    }
}
