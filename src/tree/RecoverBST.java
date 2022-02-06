package tree;


public class RecoverBST {

    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {

        helperUsingInOrder(root);

        //swap logic
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helperUsingInOrder(TreeNode root) {

        if(root == null) {
            return;
        }

        helperUsingInOrder(root.left);

        if(previous != null && previous.val > root.val) {

            if(first == null) {
                first = previous;
            }
            second = root;
        }

        previous = root;

        helperUsingInOrder(root.right);
    }

}

