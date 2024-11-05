package skillbuilders.Stack2;

public class Stack2Demo 
{

	public static void main(String[] args) 
	{
		Stack2 s2 = new Stack2(4);
		
		System.out.println("Adding \"red\" and \"yellow \" to stack. ");
		s2.push("red"); // Adds red to stack
		s2.push("yellow"); // Adds yellow to stack
		System.out.print("Top of stack: "+ s2.top() + "\n"); // Display info about stack
		System.out.print("Items in stack: "+ s2.size() + "\n"); 
		
		// Remove top item (yellow); new top item is red
		System.out.println("\n" + "Removing top item.");
		s2.pop(); // Remove top item
		System.out.print("Top of stack: "+ s2.top() + "\n"); // Display updates
		System.out.print("Items in stack: "+ s2.size() + "\n");
		



	}

}