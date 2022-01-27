package linkedlist;

/**
 * @author amgarg
 */
public class ReorderLinkedList {

    public void reorderList(Node head) {

        Node mid = getMid(head);

        //break LL two parts

        Node rest = mid.next;
        mid.next = null;

        Node head1 = head;

        Node head2 = reverseLL(rest);
        mergeInZigZag(head1, head2);

    }

    private void mergeInZigZag(Node head1, Node head2) {
        while(head2 != null) {
            Node next = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = next;
        }
    }


    public static Node reverseLL(Node head) {

        Node currentHead = head;
        Node restLLHead = null;
        Node recentHead = null;


        while (currentHead != null) {
            restLLHead = currentHead.next;
            currentHead.next = recentHead;
            recentHead = currentHead;
            currentHead = restLLHead;
        }

        head = recentHead;

        return head;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    public static void main(String[] args) {

    }
}
