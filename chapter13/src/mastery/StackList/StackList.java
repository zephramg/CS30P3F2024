package mastery.StackList;

public class StackList {
    private Node top;

    // Inner Node class to represent each element in the stack
    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    // Constructor for an empty stack
    public StackList() {
        top = null;
    }

    // Push operation to add an element to the top of the stack
    public void push(Object data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation to remove the top element from the stack
    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Object data = top.data;
        top = top.next;
        return data;  
    }

    // Peek operation to view the top element without removing it
    public Object peek() { 
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
