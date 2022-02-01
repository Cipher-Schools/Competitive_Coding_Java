package stackqueues;


public class MinStack {

    class Node {
        int value;
        int min;
        Node next;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Node head;

    public MinStack() {
        this.head = null;
    }

    public void push(int val) {
        if(this.head == null) {
            Node node = new Node(val, val);
            head = node;
        } else {
            int min = Math.min(head.min, val);
            Node node = new Node(val, min);
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if(this.head != null) {
            head = head.next;
        }

    }

    public int top() {

        if(this.head != null) {
            return this.head.value;
        }
        return Integer.MAX_VALUE;
    }

    public int getMin() {
        if(this.head != null) {
            return this.head.min;
        }
        return Integer.MAX_VALUE;
    }
}
