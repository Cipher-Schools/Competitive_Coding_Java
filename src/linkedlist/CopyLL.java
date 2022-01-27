package linkedlist;


public class CopyLL {

    public Node copyRandomList(Node head) {

        Node original = head;

        if(head == null) {
            return head;
        }

        /**
         * Create a clone of nodes and attach into original LL
         *
         */
        while(original !=  null && original.next != null) {
            Node clonedNode = new Node(original.data);
            Node next =original.next;
            original.next = clonedNode;
            clonedNode.next = next;
            original = original.next.next;
        }

        original.next = new Node(original.data);

        original = head;

        /**
         * Point Random pointers of cloneNodes to clonedNodes using
         * originalNodes Random Pointer
         */
        while (original != null && original.next != null) {
            if(original.random != null) {
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }

        /**
         * Separate LL
         */
        original = head;
        Node cloned = head.next;
        Node clonedHead = head.next;

        while(original.next != null && cloned.next != null) {
            original.next = original.next.next;
            cloned.next = cloned.next.next;
            original = original.next;
            cloned = cloned.next;
        }

        original.next = null;

        return clonedHead;

    }
}
