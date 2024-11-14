package mastery.StackList;

public class StackListDemo {
    public static void main(String[] args) {
        StackList stack = new StackList();

        // Pushing elements onto the stack
        System.out.println("Pushing elements: 10, 20, 30");
        stack.push(10);
        stack.push(20); 
        stack.push(30);

        // Peeking at the top element
        System.out.println("Top element (peek): " + stack.peek());

        // Popping elements from the stack
        System.out.println("\n" + "Popping elements:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // Trying to peek or pop from an empty stack
        try {
            System.out.println("\n" + "Attempting to peek on an empty stack:");
            System.out.println(stack.peek());
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            System.out.println("\n" + "Attempting to pop from an empty stack:");
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
