public class Queue<T> extends LinkedList<T> {

    public void enqueue(T item) {
        add(item);
    }

    public T dequeue() {
        if (getSize() == 0) {
            return null;
        }
        T firstElement = get(0);
        remove(0);
        return firstElement;
    }

    // testing the queue

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("cherry");
        System.out.println(queue); // [apple, banana, cherry]

        String first = queue.dequeue();
        System.out.println(first); // apple
        System.out.println(queue); // [banana, cherry]

        queue.enqueue("date");
        System.out.println(queue); // [banana, cherry, date]

        String second = queue.dequeue();
        System.out.println(second); // banana
        System.out.println(queue); // [cherry, date]

        String third = queue.dequeue();
        System.out.println(third); // cherry
        System.out.println(queue); // [date]

        String fourth = queue.dequeue();
        System.out.println(fourth); // date
        System.out.println(queue); // []
    }
}
