package topic10.mylinkedlink;

public class Node {
    Node next;
    Object data;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
