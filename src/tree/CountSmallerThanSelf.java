package tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class NodeInfo {
    NodeInfo left;
    NodeInfo right;
    int data;
    int count;

    public NodeInfo(int data) {
        this.data = data;
        count = 1;
    }
}
public class CountSmallerThanSelf {


    public static List<Integer> countSmaller(int[] nums) {

        List<Integer> result = new ArrayList<>(nums.length);
        NodeInfo root = new NodeInfo(nums[nums.length - 1]);
        result.set(nums.length - 1, 0);
        for(int index =  nums.length - 2; index >= 0; index--) {
            int smallerCount = getFromTree(root, nums[index]);
            result.set(index, smallerCount);
        }
        return result;
    }

    private static int getFromTree(NodeInfo root, int num) {
        int smallerCount = 0;
        NodeInfo node = new NodeInfo(num);
        boolean isAttached = false;

      while (!isAttached) {
          if (node.data <= root.data) {
              root.count++;
              if (root.left == null) {
                  root.left = node;
                  isAttached = true;
              } else {
                  root = root.left;
              }
          } else {
              smallerCount += root.count;
              if (root.right == null) {
                  root.right = node;
                  isAttached = true;
              } else {
                  root = root.right;
              }
          }
      }
      return smallerCount;
    }

    public static void main(String[] args) {

        int [] ans = {5,2,6,1};
        countSmaller(ans);
    }
}
