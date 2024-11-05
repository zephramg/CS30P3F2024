package skillbuilders.Stack3;

import java.util.ArrayList;

public class Stack3 
{
    private ArrayList<Object> data; // ArrayList to hold stack elements
    private int top; // Keeps track of the top element index

    public Stack3() 
    {
        data = new ArrayList<>();
        top = -1; // Initial value of top, indicating an empty stack
    }

    // Returns the top element without removing it
    public Object top() 
    {
        if (!isEmpty()) 
        {
            return data.get(top);
        }
        return null; // Return null if the stack is empty
    }

    // Removes and returns the top element
    public Object pop() 
    {
        if (!isEmpty()) 
        {
            Object topItem = data.get(top);
            data.remove(top);
            top -= 1; // Corrected to decrement top by 1
            return topItem;
        }
        return null; // Return null if the stack is empty
    }

    // Pushes a new element onto the stack
    public void push(Object item) 
    {
        top += 1;
        data.add(top, item);
    }

    // Checks if the stack is empty
    public boolean isEmpty() 
    {
        return top == -1;
    }

    // Returns the number of elements in the stack
    public int size() 
    {
        return top + 1;
    }

    // Empties the stack
    public void makeEmpty() {
        data.clear();
        top = -1;
    }
}
