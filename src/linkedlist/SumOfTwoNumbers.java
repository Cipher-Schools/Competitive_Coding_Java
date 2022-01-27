package linkedlist;


public class SumOfTwoNumbers {



    public static Node sum(Node head1, Node head2) {

        Node currentHead1 = head1;
        Node currentHead2 = head2;

        Node resultHead =
                recursion_add(currentHead1, currentHead2);

        Node newHead = resultHead;
        if(resultHead.data > 9) {
            resultHead.data = resultHead.data % 10;
            newHead = new Node(1);
            newHead.next = resultHead;
        }

        return newHead;
    }
    public static Node recursion_add(Node head1, Node head2) {

        if(head1 == null || head2 == null) {
            return null;
        }

        Node resultHead =
                recursion_add(head1.next, head2.next);

        int carry = 0;

        if(resultHead != null && resultHead.data > 9) {
            resultHead.data = resultHead.data % 10;
            carry = 1;
        }

        int sum = head1.data + head2.data + carry;
        Node resultNode = new Node(sum);

        resultNode.next = resultHead;
        resultHead = resultNode;
        //create Result node
        return resultHead;



    }

    public static void main(String[] args) {

        Node head1 = new Node(9);
        head1.next = new Node(9);

        Node head2 = new Node(9);
        head2.next = new Node(9);

        Node sum =
                sum(head1, head2);

        NodeUse.printLinkedList(sum);
    }
}
