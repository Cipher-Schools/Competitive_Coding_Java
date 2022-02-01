package tree;

/**
 * @author amgarg
 */
public class CompleteBinaryTree {


    private static int countNodes(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return  1 + leftNodes + rightNodes;
    }

    public boolean isCompleteTree(TreeNode root) {

        int countNodes = countNodes(root);
        return helper(root, 0, countNodes);

    }


    private static boolean helper(TreeNode root, int index, int numberOfNodes) {

        if(root == null) {
            return true;
        }

        if(index >= numberOfNodes) {
            return false;
        }

        boolean isLeftCompleteBinaryTree = helper(root.left, 2 * index + 1, numberOfNodes);
        boolean isRightCompleteBinaryTree = helper(root.left, 2 * index + 2, numberOfNodes);

        return isLeftCompleteBinaryTree && isRightCompleteBinaryTree;
    }
}
