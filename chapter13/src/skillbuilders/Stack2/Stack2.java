package skillbuilders.Stack2;

public class Stack2 
{
	private Object[] data;
	private int top;
	
	public Stack2(int maxItems)
	{
		data = new Object[maxItems];
		top = -1;
		
	}
	
	public Object top()
	{
		return(data[top]);
	}
	
	public Object pop()
	{
		top = top - 1;
		return(data[top + 1]);
	}
	
	public void push(Object item)
	{
		if(top < data.length - 1)
		{
			top = top + 1;
			data[top] = item;
			
		}
	}
	
	public boolean isEmpty()
	{
		if(top == -1)
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
		if(isEmpty())
		{
			return(0);
		}
		else
		{
			return(top + 1);
		}
	}
	
	public void makeEmpty()
	{
		top = -1;
	}

}