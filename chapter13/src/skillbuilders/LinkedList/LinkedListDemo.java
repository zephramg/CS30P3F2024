package skillbuilders.LinkedList;

public class LinkedListDemo 
{
	// TODO Add messages that indicate what the program is doing
	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList();

		list.addAtFront("Sachar");
		list.addAtFront("Osborne");
		list.addAtFront("Suess");
		System.out.println("List has " + list.size() + " items.");
		System.out.println(list);
		
		// Adds items to end of lost
		list.addAtEnd("Blume");
		list.addAtEnd("Dahl");
		System.out.println(list);

		// Clears List
		list.makeEmpty();
		System.out.println("List has " + list.size() + " items.");
		System.out.println(list);
		
	}

} 