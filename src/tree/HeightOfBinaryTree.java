package tree;


public class HeightOfBinaryTree {


    public static int height(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int leftTreeHeight = height(root.left);
        int rightTreeHeight = height(root.right);

        int maxHeight = Math.max(leftTreeHeight, rightTreeHeight )+ 1;
        return maxHeight;
    }


    static int globalMax_diamter = 0;
    public static int diameter(TreeNode root) {

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

         globalMax_diamter = Math.max(globalMax_diamter, 1 + leftHeight + rightHeight);

        int maxHeight = Math.max(leftHeight, rightHeight )+ 1;
        return maxHeight;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        root.left.left = new TreeNode(4);

       diameter(root);

        System.out.println(globalMax_diamter);

    }

}
