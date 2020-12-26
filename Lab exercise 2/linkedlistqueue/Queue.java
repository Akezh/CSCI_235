package linkedlistqueue;

public interface Queue<T> {
    void push(T val);

    T peek() throws Exception;

    void pop() throws Exception;

    void clear();

    int size();

    boolean empty();
}
