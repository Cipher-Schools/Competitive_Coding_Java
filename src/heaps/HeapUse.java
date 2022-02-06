package heaps;


public class HeapUse {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.addElement(5);
        minHeap.addElement(8);
        minHeap.addElement(2);
        minHeap.addElement(11);

        System.out.println(minHeap.getMin());

        System.out.println(minHeap.removeMin());

        System.out.println(minHeap.getMin());
    }
}
