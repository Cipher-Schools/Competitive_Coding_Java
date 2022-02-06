package tree;



class TreeNodeInfo {

    boolean isBst;

    int size;

    int max;

    int min;

    public TreeNodeInfo() {
        this.isBst = true;
        this.size = 0;
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
    }
}
public class LargestBst {

    public static int largestBSTSubtree(TreeNode root) {

        TreeNodeInfo  treeNodeInfo = helper(root);
        return treeNodeInfo.size;
    }

    private static TreeNodeInfo helper(TreeNode root) {

        if(root == null) {
            return new TreeNodeInfo();
        }

        TreeNodeInfo leftTreeNodeInfo = helper(root.left);
        TreeNodeInfo rightTreeNodeInfo = helper(root.right);

        TreeNodeInfo result = new TreeNodeInfo();

        if(leftTreeNodeInfo.isBst == false || rightTreeNodeInfo.isBst == false
        || (leftTreeNodeInfo.max >= root.val || rightTreeNodeInfo.min <= root.val)) {
            result.isBst = false;
            result.size = Math.max(leftTreeNodeInfo.size, rightTreeNodeInfo.size);
            return result;
        }

        result.isBst = true;
        result.size = leftTreeNodeInfo.size + rightTreeNodeInfo.size + 1;

        if(root.left != null) {
            result.min = leftTreeNodeInfo.min;
        } else {
            result.min = root.val;
        }

        if(root.right != null) {
            result.max = rightTreeNodeInfo.max;
        } else {
            result.max = root.val;
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.right = new TreeNode(8);
        root.left.left = new TreeNode(1);

        root.right.right = new TreeNode(7);

        largestBSTSubtree(root);

    }


}
