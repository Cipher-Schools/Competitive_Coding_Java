package tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



class Pair {
    TreeNode node;
    int visitingCount;

    public Pair(TreeNode node) {
        this.node = node;
    }
}
public class Traversal {



    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return result;

    }


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Stack<Pair> stack= new Stack<>();
        stack.push(new Pair(root));

        while(!stack.isEmpty()) {

            Pair currentTreeNodePair = stack.peek();
            currentTreeNodePair.visitingCount++;

            if(currentTreeNodePair.node == null) {
                stack.pop();
            } else if(currentTreeNodePair.visitingCount == 1) {
                Pair leftTreePair = new Pair(currentTreeNodePair.node.left);
                stack.push(leftTreePair);
            } else  if (currentTreeNodePair.visitingCount == 2) {
                Pair rightTreePair = new Pair(currentTreeNodePair.node.right);
                stack.push(rightTreePair);
            } else {
                result.add(stack.pop().node.val);
            }
        }

        return result;

    }

}
