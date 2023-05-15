public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        System.out.println("List contents: " + list);

        list.addFirst("orange");
        list.remove("banana");
        list.add(2, "apple");

        System.out.println("List contents after modification: " + list);

        // Remove all elements that are equal to "apple"
        list.removeAll("apple");
        System.out.println("List contents after removing all apples: " + list);
    }

}
