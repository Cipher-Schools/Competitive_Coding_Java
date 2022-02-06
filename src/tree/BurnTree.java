package tree;


import java.util.LinkedList;
import java.util.Queue;

public class BurnTree {

    static Queue<TreeNode> queue = new LinkedList<>();
    public static int burnTree(TreeNode root, int targetNode) {

        if(root == null) {
            return 0;
        }

        if(root.val == targetNode) {
            System.out.println(root.val + " ");
            if(root.left != null) {
                queue.add(root.left);
            }
            if(root.right != null) {
                queue.add(root.right);
            }
             return  1;
        }
        int left = burnTree(root.left, targetNode);
        if(left == 1) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.val + " ");

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            if(root.right != null) {
                queue.add(root.right);
            }
            System.out.print(root.val);
            System.out.println();
            return 1;
        }

        int right = burnTree(root.right, targetNode);
        if(right == 1) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.val + " ");

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            if(root.left != null) {
                queue.add(root.left);
            }
            System.out.print(root.val);
            System.out.println();
            return 1;
        }

        return  0;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        burnTree(root, 5);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.val + " ");

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            System.out.println();
        }
    }
}
