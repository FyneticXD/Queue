public class CustomQueue {
    private Node head;
    private Node tail; 


    public CustomQueue() {
        this.head = null;
        this.tail = null;
    }


    public void enqueue(String item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    public String dequeue() {
        if (isEmpty()) {
            return null;
        }

        String item = head.item;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
