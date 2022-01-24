package searching_and_sorting;


public class MajorityElement {


    public int majorityElement(int[] nums) {


        int element = getCandidate(nums);
        int majorityCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == element) {
                majorityCount++;
            }
        }

        if(majorityCount > nums.length / 2) {
            return element;
        }
        return -1;

    }


    public int getCandidate(int [] num) {

        int majorityElementIndex = 0;
        int majorityCount = 0;

        for(int i = 0; i < num.length; i++) {
            if(num[i] == num[majorityElementIndex]) {
                majorityCount++;
            } else {
                majorityCount--;
            }
            if(majorityCount == 0) {
                majorityElementIndex = i;
                majorityCount = 1;
            }
        }
        return  num[majorityElementIndex];
    }

}
