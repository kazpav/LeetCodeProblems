package leetcode.medium.kth_smallest_element_in_a_bst;

/**
 * This class represents BST, that we need in {@code kth_smallest_element_in_a_bst} class
 * to provide logic it needs
 *
 * @author Pavel Kazarin
 * @see leetcode.medium.kth_smallest_element_in_a_bst.KthSmallestElementInABST
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Initializes new {@code TreeNode} object
     *
     * @param x data to put into root element
     */
    private TreeNode(int x) {
        val = x;
        left = right = null;
    }

    /**
     * This method builds BST
     *
     * @param root root element
     * @param data data to put into BST
     * @return created TreeNode element
     */
    static TreeNode insert(TreeNode root, Integer data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if (data <= root.val) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
