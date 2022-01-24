package bactracking;


import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(ans, nums, temp);
        return ans;
    }

    private void helper(List<List<Integer>> ans, int[] nums,
                        ArrayList<Integer> temp) {

        if(temp.size() == nums.length) {
            ArrayList<Integer> output = new ArrayList<>(temp);
            ans.add(output);
            return;
        }
        for(int index  = 0; index < nums.length; index++) {
            if(!temp.contains(nums[index])) {
                //add in arrayList
                temp.add(nums[index]);
                helper(ans, nums, temp);
                //Backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
