import java.util.NoSuchElementException;

// Testing the stack class

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());

        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());

        // testing exception
        try {
            stack.pop();
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException caught!");
        }
    }

}