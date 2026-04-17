package topic10.mylinkedlink;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        Node temp = head;
        Node newNode = new Node(element);
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        numNodes++;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= numNodes) return false;

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
        return true;
    }

    public int size() {
        return numNodes;
    }


}
