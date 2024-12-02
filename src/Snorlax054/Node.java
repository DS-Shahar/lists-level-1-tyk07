package Snorlax054;

public class Node<Interger> {
	private int data;   
    private Node<Interger> next;
    
    public Node(int data) 
    {
        this.data = data;
        this.next = null; // Default value
    }
    public int getData() 
	{
		return data;
	}
	public void setData(int data) 
	{
		this.data = data;
	}
	public Node<Interger> getNext() 
	{
		return next;
	}
    public void setNext(Node<Interger> next)
    {
    	this.next = next;
    }
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        Node<Interger> current = this;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}