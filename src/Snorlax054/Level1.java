package Snorlax054;
import java.util.*;
public class Level1 {
	public static Scanner reader = new Scanner(System.in);
	public static Node<Integer> convert(int[] arr) //1
	{
		Node<Integer> a = new Node<Integer>(arr[0]);
		Node<Integer> b  = a;
		for(int i = 1; i < arr.length; i++)
		{
			Node<Integer> c = new Node<Integer>(arr[i]);
			b.setNext(c);
			b = c;
		}
		return a;
	}
	public static void printer(Node<Integer> a) //2
	{
		if(a.getNext() == null)
		{
			System.out.println(a.getData());
			return;
		}
		printer(a.getNext());
		System.out.println(a.getData());
	}
	public static Node<Integer> positive() //3
	{
		System.out.println("enter positive number or -1 to exit");
		int x = reader.nextInt();
		if(x == -1)
		{
			return null;
		}
		Node<Integer> a = new Node<Integer>(x);
		Node<Integer> b = a;
		while(x != -1)
		{
			System.out.println("enter positive number or -1 to exit");
			x = reader.nextInt();
			if(x != -1)
			{
				Node<Integer> c = new Node<Integer>(x);
				b.setNext(c);
				b = c;
			}
		}
		return a;
	}
	public static void even(Node<Integer> a) //4
	{
		if(a.getData() % 2 == 0)
		{
			System.out.println(a.getData());
		}
		if(a.getNext() == null)
		{
			return;
		}
		even(a.getNext());
	}
	public static boolean inNode(Node<Integer> a, int x) //5
	{
		if(a.getData() == x)
		{
			return true;
		}
		if(a.getNext() == null)
		{
			return false;
		}
		return inNode(a.getNext(), x);
	}
	public static Node<Integer> delete(Node<Integer> a, int x)  //6
	{
	    if (a == null)
	    {
	    	return null;
	    }
	    Node<Integer> b = a;
	    Node<Integer> c = null;
	    boolean flag = false;

	    while (b != null) 
	    {
	        if (b.getData() == x || flag == true) 
	        {
	            flag = true;
	            if (b.getNext() != null) 
	            {
	                b.setData(b.getNext().getData());
	                c = b;
	                b = b.getNext();
	            } else 
	            {
	                if (c != null) 
	                {
	                    c.setNext(null);
	                } 
			else 
	                {
	                    a = null;
	                }
	                break;
	            }
	        }
	        else 
	        {
	            c = b;
	            b = b.getNext();
	        }
	    }
	    if (flag == false && a != null && a.getData() == x) 
	    {
	        a = a.getNext();
	    }

	    return a;
	}
	public static Node<Integer> deleteIndex(Node<Integer> a, int x) //7
	{
	    if (a == null)
	    {
	    	return null;
	    }
	    Node<Integer> b = a;
	    Node<Integer> c = null;
	    boolean flag = false;
	    int count = 0;
	    while (b != null) 
	    {
	        if (count == x || flag == true) 
	        {
	            flag = true;
	            if (b.getNext() != null) 
	            {
	                b.setData(b.getNext().getData());
	                c = b;
	                b = b.getNext();
	            } else 
	            {
	                if (c != null) 
	                {
	                    c.setNext(null);
	                } else 
	                {
	                    a = null;
	                }
	                break;
	            }
	        }
	        else 
	        {
	            c = b;
	            b = b.getNext();
	        }
	        count++;
	    }
	    if (flag == false && a != null && a.getData() == x) 
	    {
	        a = a.getNext();
	    }

	    return a;
	}
	// Helper method to remove the first occurrence of `value` in `b`, used for 8-11
	private static boolean removeAndMatch(Integer value, Node<Integer> b)
	{
	    Node<Integer> b2 = b;
		if (b2 == null) 
	    {
	        return false;
	    }

	    Node<Integer> prev = null;
	    Node<Integer> current = b2;
	    while (current != null)
	    {
	        if (current != null && current.getData() == value) 
	        {
	            // Match found, remove the node
	            if (prev != null) 
	            {
	                prev.setNext(current.getNext());
	            } else 
	            {
	                // Special case: Removing the head
	                if (current.getNext() != null) 
	                {
	                    Node<Integer> b22 = b;
						b22.setData(current.getNext().getData());
	                    b22.setNext(current.getNext().getNext());
	                } else 
	                {
	                    // List becomes empty
	                    b = null;
	                }
	            }
	            return true;
	        }
	        prev = current;
	        current = current.getNext();
	    }

	    return false; // No match found
	}
	public static boolean inList(Node<Integer> a, Node<Integer> b) //8
	{
		if(a == null)
		{
			return true;
		}
		if (b == null) 
		{
	        return false;
	    }
		if (removeAndMatch(a.getData(), b)) 
		{
	        return inList(a.getNext(), b);
	    }
		return false;
	}
	public static void PrintDupe(Node<Integer> a, Node<Integer> b) //9
	{
		while(a != null && b != null)
		{
			if (removeAndMatch(a.getData(), b)) 
			{
		        System.out.println(a.getData());
		    }
			a = a.getNext();
		}
		return;
	}
	public static Node<Integer> BuildNode(Node<Integer> a, Node<Integer> b) //10
	{
		Node<Integer> c = null;
		Node<Integer> d = null;
		while(a != null && b != null)
		{
			if (removeAndMatch(a.getData(), b)) 
			{
				Node<Integer> e = new Node<Integer>(a.getData());
				if(c == null)
				{
					c = e;
					d = c;
				}
				else
				{
					d.setNext(e);
					d = e;
				}
		    }
			a = a.getNext();
		}
		return c;
	}
	public static Node<Integer> MutualDeletion(Node<Integer> a, Node<Integer> b)
	{
		Node<Integer> c = new Node<>(0);
	    c.setNext(a);
	    Node<Integer> d = c;
	    Node<Integer> e = a;
	    while (e != null) {
	        if (removeAndMatch(e.getData(), b)) 
	        {
	            d.setNext(e.getNext());
	        } else 
	        {
	            d = e;
	        }
	        e = e.getNext();
	    }
	    return c.getNext();
	}
	public static void main(String[] args) {
		int[] a = {5, 8, 2, 1, 3, 7};
		Node<Integer> b = new Node<Integer>(0);
		b = convert(a);
		System.out.println(b);
		Node<Integer> c = positive();
		Node<Integer> d = BuildNode(b, c);
		System.out.println(d);
		//printer(b);
		//System.out.println(c);
		//even(c);
		//System.out.println(inNode(b, 3));
		//System.out.println(delete(b, 5));
		//System.out.println(deleteIndex(b, 4));
		//System.out.println(inList(b, c));
		//PrintDupe(b, c);
		System.out.println(MutualDeletion(b, d));
	}

}
