package tree;

import linkedlist.Node;

/**
 * @author amgarg
 */
public class PopulateNextPointer {

    public Node connect(Node root) {

        Node mainRoot = root;
        while(root != null) {
            Node tempNode = new Node(Integer.MIN_VALUE);
            Node currentNode = tempNode;
            while(root != null) {
                if(root.left != null) {
                    currentNode.next = root.left;
                    currentNode = currentNode.next;
                }

                if(root.right != null) {
                    currentNode.next = root.right;
                    currentNode = currentNode.next;
                }
                root = root.next;
            }
            root = tempNode.next;
        }

        return mainRoot;
    }
}
