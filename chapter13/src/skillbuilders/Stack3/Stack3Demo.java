package skillbuilders.Stack3;

public class Stack3Demo 
{

    public static void main(String[] args) 
    {
        Stack3 stack = new Stack3();

        // Push elements onto the stack
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        // Display the stack size and top element
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.top());

        // Pop elements from the stack and display each
        System.out.println("Popping elements:");
        while (!stack.isEmpty()) 
        {
            System.out.println("Popped: " + stack.pop());
        }

        // Display stack status after emptying
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack size after emptying: " + stack.size());

        // Test the makeEmpty method
        stack.push("New Element");
        System.out.println("Stack size before makeEmpty: " + stack.size());
        stack.makeEmpty();
        System.out.println("Stack size after makeEmpty: " + stack.size());
    }
}
