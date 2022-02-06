package heaps;


import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minH;
    private PriorityQueue<Integer> maxH;

    public MedianFinder() {
        minH = new PriorityQueue<Integer>();
        maxH = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        maxH.add(num);
        minH.add(maxH.poll());
        if(maxH.size() > minH.size()) { maxH.add(minH.poll()); }

    }

    public double findMedian() {
        if(maxH.size() == minH.size()) {
            return (maxH.peek() + minH.peek()) /2.0;
        }
        return maxH.peek();
    }


}
