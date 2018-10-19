package leetcode.medium.kth_smallest_element_in_a_bst;


import org.junit.Assert;
import org.junit.Test;

/**
 * This class includes tests for {@code KthSmallestElementInABSTTest} class
 *
 * @author Pavel Kazarin
 * @see leetcode.medium.kth_smallest_element_in_a_bst.TreeNode
 * @see leetcode.medium.kth_smallest_element_in_a_bst.KthSmallestElementInABST
 */
public class KthSmallestElementInABSTTest {

    /**
     * This method fills BST with input array and
     * tests kthSmallest method
     */
    @Test
    public void kthSmallestCase1ReturnsOne() {
        Integer[] input = new Integer[]{3, 1, 4, 2};

        TreeNode root = null;
        for (Integer i : input) {
            root = TreeNode.insert(root, i);
        }

        int expectedResult = 1;
        int k = 1;

        Assert.assertEquals(expectedResult, KthSmallestElementInABST.kthSmallest(root, k));
    }

    /**
     * This method fills BST with input array and
     * tests kthSmallest method
     */
    @Test
    public void kthSmallestCase2ReturnsThree() {
        Integer[] input = new Integer[]{5, 3, 6, 2, 4, 1};

        TreeNode root = null;
        for (Integer i : input) {
            root = TreeNode.insert(root, i);
        }

        int expectedResult = 3;
        int k = 3;

        Assert.assertEquals(expectedResult, KthSmallestElementInABST.kthSmallest(root, k));
    }
}
