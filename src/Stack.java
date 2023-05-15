import java.util.NoSuchElementException;

public class Stack<T> extends LinkedList<T> {

    public void push(T e) {
        add(e);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = get(getSize()-1);
        remove(getSize()-1);
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(getSize()-1);
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
}
