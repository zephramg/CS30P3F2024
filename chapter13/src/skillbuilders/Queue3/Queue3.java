package skillbuilders.Queue3;

import java.util.ArrayList;

public class Queue3 
{
	private ArrayList<Object> data;
	private int front, rear;
	
	public Queue3()
	{
		data = new ArrayList<Object>();
		front = -1;	// no items in the array
		rear = -1;
	}
	
	public Object front() 
	{
	 	return(data.get(front));
	}
	
	public Object dequeue() 
	{
		Object item;
		
		item = data.get(front);	// get front item
		data.remove(front);	// remove front item from list
		if (front == rear) 
		{ // if dequeueing last item then make empty
			makeEmpty();
		} 
		else 
		{
			rear -= 1; // items have shifted down, so rear pointer must be moved
		}
	  	return(item); // return front item
	}
	
	public void enqueue(Object item) 
	{
	 	if (isEmpty()) 
	 	{
	 	// first item queued
	 		rear = 0;
	 		front = 0;
	 		data.add(item);
	 	} 
	 	else 
	 	{
	 		rear += 1;
	 		data.add(item);
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
	 		return(rear - front + 1);
	 	}
	}
	
	
	
	
	public void makeEmpty() 
	{
	 	front = -1;
	 	rear = -1;
	}
	
}