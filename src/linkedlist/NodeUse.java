package linkedlist;

/**
 * @author amgarg
 */
public class NodeUse {

    public static void main(String[] args) {
        Node block1 = new Node(5);

        Node block2 = new Node(10);


        Node block3 = new Node(15);

        block1.next = block2;
        block2.next = block3;

        System.out.println(block1.next);

        Node head = block1;

        Node newHead = ReverseLinkedList.reverseLL(head);
        printLinkedList(newHead);

    }

    public static void printLinkedList(Node head) {

        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }

        System.out.println("No Further Elements");





    }
}
