package tree;


public class MaxPathSum {

    int maxiumSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        helper(root);
        return maxiumSum;
    }

    public int helper(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftSumTree = Math.max(0, helper(root.left));
        int rightSumTree = Math.max(0, helper(root.right));
        maxiumSum = Math.max(maxiumSum, leftSumTree + rightSumTree + root.val);

        return Math.max(leftSumTree, rightSumTree) + root.val;

    }
}
