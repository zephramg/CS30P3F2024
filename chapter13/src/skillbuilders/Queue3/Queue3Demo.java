package skillbuilders.Queue3;

public class Queue3Demo 
{

	public static void main(String[] args) 
	{ // TODO make alternate test cases
		
		Queue3 q = new Queue3();

		System.out.println("Adding \"red\", \"yellow\", and \"orange\" to queue.");
		q.enqueue("red");
		q.enqueue("yellow");
		q.enqueue("orange");
		System.out.println("Front of queue: " + (String)q.front());
		System.out.println("Items in queue: " + q.size());
		System.out.println("Dequeueing front item: " + (String)q.dequeue());
		System.out.println("Front of queue: " + (String)q.front());
		System.out.println("Items in queue: " + q.size());
		System.out.println("Dequeueing front item: " + (String)q.dequeue());
		System.out.println("Front of queue: " + (String)q.front());
		System.out.println("Items in queue: " + q.size());
		System.out.println("Adding \"purple\" to queue.");
		q.enqueue("purple");
		System.out.println("Front of queue: " + (String)q.front());
		System.out.println("Items in queue: " + q.size());
		System.out.println("Dequeueing front item: " + (String)q.dequeue());
		System.out.println("Adding \"lime\" to queue.");
		q.enqueue("lime");
		System.out.println("Front of queue: " + (String)q.front());
		System.out.println("Items in queue: " + q.size());
		System.out.println("Dequeueing front item: " + (String)q.dequeue());
		System.out.println("Dequeueing front item: " + (String)q.dequeue());
		System.out.println("Items in queue: " + q.size());
		

	}

}