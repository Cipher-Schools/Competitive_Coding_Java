package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amgarg
 */
public class NodesAtKLevel {


    ArrayList<TreeNode> path;

    ArrayList<Integer> ans;


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        path = new ArrayList<>();
        ans = new ArrayList<>();
        findPath(root, target);

        for(int i = 0; i < path.size(); i++) {
            goKLevelsDownFromRootNode(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
        }

        return ans;

    }

    public boolean findPath(TreeNode root, TreeNode targetNode) {


        if(root == null) {
            return false;
        }

        if(root == targetNode) {
            path.add(root);
            return true;
        }

        boolean isLeftFound =
                findPath(root.left, targetNode);

        if(isLeftFound) {
            path.add(root);
            return true;
        }

        boolean isRightFound =
                findPath(root.right, targetNode);

        if(isRightFound) {
            path.add(root);
            return true;
        }

        return false;


    }

    public  void goKLevelsDownFromRootNode(TreeNode node, int deepLevel, TreeNode obstacle) {

        if(node == null || deepLevel < 0 || node == obstacle) {
            return;
        }
        if(deepLevel  == 0) {
            ans.add(node.val);
            return;
        }
        goKLevelsDownFromRootNode(node.left, deepLevel - 1, obstacle);
        goKLevelsDownFromRootNode(node.right, deepLevel - 1, obstacle);
    }
}
