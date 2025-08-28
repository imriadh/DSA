package Lab;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ValidBst {
    public static boolean isValidBST(TreeNode root) {
        // Call the helper function with initial range (-∞, +∞)
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        // Base case: If the node is null, it is a valid BST
        if (node == null) {
            return true;
        }

        // Check if the current node's value is within the allowed range
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Recursively check the left and right subtrees
        // For the left child, the range is (min, node.val - 1)
        // For the right child, the range is (node.val + 1, max)
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Example 1: [2, 1, 3]
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(isValidBST(root1)); // Output: true

        // Example 2: [5, 1, 4, null, null, 3, 6]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(isValidBST(root2)); // Output: false
    }
}