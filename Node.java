/**
 * Represents a node in the linked list used for the queue.
 */
public class Node {
    String item; // Data stored in the node
    Node next;   // Reference to the next node

    /**
     * Constructor for creating a new node.
     * @param item The data to be stored in this node.
     */
    public Node(String item) {
        this.item = item;
        this.next = null;
    }
}
