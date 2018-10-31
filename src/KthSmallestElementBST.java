package leetcode.medium.kth_smallest_element_in_a_bst;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This problem is solved and was approved by leetcode
 *
 * @author Pavel Kazarin
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/">Kth Smallest Element in a BST</a>
 * @see leetcode.medium.kth_smallest_element_in_a_bst.TreeNode
 */
class KthSmallestElementInABST {

    private static int counter = 0;
    private static int result;

    /**
     * This method finds kth smallest element in BST using Deque (stack)
     * @param root {@code Treenode} element
     * @param k elemnt to find
     * @return value of kth smallest element
     */
    static int kthSmallest(TreeNode root, int k) {

        // Deque to store tree elements and use stack's features
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        // Storing all left leafs of the tree into stack
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {

            // Taking top elements of the stack
            TreeNode stackTopElement = stack.pop();

            // Checking if stackTopElement is  Kth smallest element
            k--;
            if (k == 0) {
                return stackTopElement.val;
            }

            // Storing all left leafs of stackTopElement's right subtree
            TreeNode sideLeaf = stackTopElement.right;
            while (sideLeaf != null) {
                stack.push(sideLeaf);
                sideLeaf = sideLeaf.left;
            }
        }
        return -1;
    }

    /**
     * This method finds kth smallest element in BST using recursion
     * @param root {@code TreeNode} element
     * @param k elemnt to find
     * @return value of kth smallest element
     */
    static int kthSmallestRecursion(TreeNode root, int k){
        // Starting traversal
        rec(root, k);
        return result;
    }

    /**
     * Recursive method to find smallest element
     * @param node {@code TreeNode} element
     * @param k element to find
     */
    private static void rec(TreeNode node, int k){
        if(node == null){
            return;
        }
        // Storing all left elements
        rec(node.left, k);

        // Checking if current node is kth smallest element
        counter++;
        if(counter == k){
            result = node.val;
            return;
        }
        // Switching to right subtree
        rec(node.right, k);
    }
}
