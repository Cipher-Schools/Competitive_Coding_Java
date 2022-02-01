package stackqueues;

import java.util.Stack;

/**
 * @author amgarg
 */
public class LargestHistorgram {

    public int largestRectangleArea(int[] heights) {
        //Create a stack

        Stack<Integer> stack = new Stack<>();

        int index = 0;
        int maxArea = 0;

        while(index < heights.length) {
            int currentBuilding = heights[index];
            if(stack.isEmpty() || currentBuilding >=  heights[stack.peek()]) {
                stack.push(index);
                index++;
            } else {
                //Yes, we got right boundary
                int previousBuildingIndex = stack.pop();
                int height = heights[previousBuildingIndex];
                int width;

                if(stack.isEmpty()) {
                    width = index;
                } else {
                    width = index - stack.peek() - 1;
                }


                int area = height * width;
                maxArea= Math.max(area, maxArea);
            }
        }

        while(!stack.isEmpty()) {
            int previousBuildingIndex = stack.pop();
            int height = heights[previousBuildingIndex];
            int width;

            if(stack.isEmpty()) {
                width = index;
            } else {
                width = index - stack.peek() - 1;
            }

            int area = height * width;
            maxArea= Math.max(area, maxArea);
        }

        return maxArea;

    }
    public static void main(String[] args) {

    }
}
