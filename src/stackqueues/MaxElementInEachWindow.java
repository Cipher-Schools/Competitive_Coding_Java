package stackqueues;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxElementInEachWindow {


    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();

        int currentIndex = 0;

        for(currentIndex = 0; currentIndex < k; currentIndex++) {

            while (!deque.isEmpty() && nums[currentIndex] >=  nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(currentIndex);
        }

        for(; currentIndex < nums.length; currentIndex++) {

            result.add(nums[deque.peek()]);

            //Remove elements which are outside of the current window

            if(!deque.isEmpty() && deque.peek() <= currentIndex - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[currentIndex] >=  nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(currentIndex);

        }

        result.add(nums[deque.peek()]);

       deque.clear();

       int [] resultant = new int[result.size()];

       for(int index = 0; index < result.size(); index++ ) {
           resultant[index] = result.get(index);
       }

       return resultant;
    }



}
