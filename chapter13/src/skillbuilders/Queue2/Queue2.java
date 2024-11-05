package skillbuilders.Queue2;

public class Queue2 
{
	private Object[] data;
	private int front, rear, maxSize;
	
	public Queue2(int maxItems) 
	{
		data = new Object[maxItems];
		front = -1;	// no items in the array
		rear = -1;
		maxSize = maxItems;
	}
	
	public Object front() 
	{
	 	return(data[front]);
	}
	
	public Object dequeue() 
	{
		Object item;
		
		item = data[front];	// get front item
		if (front == rear)  
		{					// if dequeueing last item then make empty
			makeEmpty();
		} 
		else 
		{
			front = (front + 1) % maxSize;	//  move pointer to next item
		}
	  	return(item); //return front item
	}
	
	public void enqueue(Object item) 
	{
	 	if (isEmpty()) 
	 	{ //first item queued
	 		rear = 0;
	 		front = 0;
	 		data[rear] = item;
	 	} 
	 	else 
	 	{
	 		rear = (rear + 1) % maxSize;
	 		data[rear] = item;
	 	}
	}

	public boolean isEmpty() 
	{
	 	if (front == -1 && rear == -1) 
	 	{
	 		return(true);
	 	} 
	 	else 
	 	{
	 		return(false);
	 	}
	}
	
	public int size() 
	{
	 	if (isEmpty()) 
	 	{
	 		return(0);
	 	} 
	 	else 
	 	{
	 		if (rear > front) 
	 		{ // front item is "in front" of rear item
	 			return(rear - front + 1);
	 		} 
	 		else if (front == rear + 1) 
	 		{ // queue is full
	 			return(maxSize);
	 		} 
	 		else 
	 		{
	 			return(front - rear + 1); // front item is "behind" rear item
	 		}
	 	}
	}
	
	public void makeEmpty() 
	{
	 	front = -1;
	 	rear = -1;
	}
}