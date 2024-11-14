package mastery; 

import java.util.Scanner;
import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        // Create a Scanner for user input and a Stack to store integers
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("Enter up to 10 numbers to reverse, or enter 999 to finish early:");
        
        int count = 0;  // Counter to track the number of inputs
        while (count < 10) {  // Limit input to 10 numbers
            System.out.print("Enter number " + (count + 1) + ": ");
            int input = scanner.nextInt();
            
            if (input == 999) {  // Check if the user wants to stop early
                break;
            }
            
            stack.push(input);  // Push the valid input onto the stack
            count++;  // Increment the count of numbers entered
        }
        
        // Display reversed numbers by popping from the stack
        System.out.println("\nReversed numbers:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");  // Pop each element to reverse order
        }
        scanner.close(); 
    }
}
 