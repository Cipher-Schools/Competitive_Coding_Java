package linkedlist;


public class ReverseLinkedList {


    /**
     * Approach 1
     * T.C - O(n)
     * S.C - O(1)
     * @param head
     * @return
     */
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


    public static Node reverseRecursive(Node head) {

        Node restLLHead = reverseLL(head.next);

        head.next.next = restLLHead;

        head.next = null;

        return restLLHead;
    }
}
