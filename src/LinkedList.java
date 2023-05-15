import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    public void add(T e) {
        addLast(e);
    }

    public void add(int i, T e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<T> current = getNode(i);
            Node<T> newNode = new Node<>(current.prev, e, current);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = getNode(i);
        return current.element;
    }

    public void remove(T e) {
        Node<T> current = first;
        while (current != null && !current.element.equals(e)) {
            current = current.next;
        }
        if (current != null) {
            removeNode(current);
        }
    }

    public void remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = getNode(i);
        removeNode(current);
    }

    public void removeAll(T e) {
        Node<T> current = first;
        while (current != null) {
            if (current.element.equals(e)) {
                removeNode(current);
            }
            current = current.next;
        }
    }

    public void addFirst(T e) {
        Node<T> newNode = new Node<>(null, e, first);
        if (first == null) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.element.toString()); // [1, 2, 3]
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void addLast(T e) {
        Node<T> newNode = new Node<>(last, e, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    private Node<T> getNode(int index) {
        if (index < size / 2) {
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node<T> current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    private void removeNode(Node<T> node) {
        if (node == null) {
            return;
        }
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        size--;
    }


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = current.element;
            current = current.next;
            return element;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}