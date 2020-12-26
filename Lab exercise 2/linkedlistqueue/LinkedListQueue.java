package linkedlistqueue;

public class LinkedListQueue<T> implements Queue<T> {
    class Node<T> {
        private T value;
        private Node link;

        public Node(T val) {
            value = val;
        }

        public T getValue() {
            return value;
        }

        public void setLink(Node next) {
            link = next;
        }

        public Node getLink() {
            return link;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void push(T val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            size++;
            return;
        }

        tail.setLink(new Node(val));
        tail = tail.getLink();

        size++;
    }

    public T peek() throws Exception {
        if (size == 0)
            throw new Exception("PEEK: The queue is empty, no peek!");

        return head.getValue();
    }

    public void pop() throws Exception {
        if (size == 0)
            throw new Exception("POP: The queue is already empty!");

        head = head.getLink();
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public String toString() {
        Node tempNodeIterator = head;
        StringBuilder ans = new StringBuilder();
        int i = 0;

        ans.append("[ ");
        while (tempNodeIterator != null) {
            if (i == 0) {
                i++;
            } else {
                ans.append(", ");
            }
            ans.append(tempNodeIterator.getValue());
            tempNodeIterator = tempNodeIterator.getLink();
        }
        ans.append(" ]");
        return ans.toString();
    }
}
